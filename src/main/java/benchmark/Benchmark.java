package benchmark;

import io.etcd.jetcd.Client;
import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.KV;

import java.io.FileNotFoundException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.Arrays;

import java.util.concurrent.ExecutionException;

import io.etcd.jetcd.kv.GetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


class Benchmark {
    public static void main(String[] args) {
        try {
            // create client
            Client client = Client.builder().endpoints("http://localhost:2379").build();
            KV kvClient = client.getKVClient();

            BufferedReader reader = new BufferedReader(new FileReader("/home/mircea/CTI/AN1/SEM1/SABD/PROIECT/iot_telemetry_data.csv"));

            String line = null;
            int nrLines = 0;
            final int[] scaleFactorArr = new int[]{200_000  };
            final int repeatNr = 5; 
            final int nrKeys = 405_184;

            String[] charKeys = new String[nrKeys];
            String[] charValues = new String[nrKeys];
            int end=0, start=0;
            line = reader.readLine();//first line contains description not actual values
            while ((line = reader.readLine())!= null && nrLines < nrKeys) {
		        charValues[nrLines]=line;
                charKeys[nrLines]=String.valueOf(++nrLines);
	        }
            System.out.println("nr lines: " + nrLines);
            reader.close();
            

            for (int i = 0; i < scaleFactorArr.length; ++i) {
                String[] charKeysCopy = Arrays.copyOfRange(charKeys,0,scaleFactorArr[i]);
                String[] charValuesCopy = Arrays.copyOfRange(charValues,0,scaleFactorArr[i]);
                ByteSequence[] keySeqArr = getByteSequence(charKeysCopy); //key sequentaly array
                ByteSequence[] valSeqArr = getByteSequence(charValuesCopy); //values sequentaly array
                double average;
                double[] durationArr = new double[repeatNr];
                System.out.println("Scalation factor : " + scaleFactorArr[i]);
                for (int j = 0; j < repeatNr; ++j) {
                    long startTime = System.currentTimeMillis();
                    put(kvClient, keySeqArr, valSeqArr);
                    long endTime = System.currentTimeMillis();

                    durationArr[j] = (double)(endTime - startTime);
                    System.out.println("Inseration time:"+ durationArr[j] + "s");

                    delete(kvClient,keySeqArr);
                }

                //computing average
                double sum = 0;
                for(int j = 0; j < repeatNr; ++j) {
                    sum += durationArr[j];
                }
                average = sum / (double)repeatNr;

                //computing standard deviation
                sum = 0;
                for (int j = 0; j < repeatNr; ++j) {
                    double diff = average-durationArr[j];
                    sum += diff * diff;
                }
                double stddev = Math.sqrt(1.0/(double)repeatNr*sum);
                System.out.println("Mean : " + average + ". Std dev: " + stddev + "\n");
            }
            

            

            // // get the CompletableFuture
            // CompletableFuture<GetResponse> getFuture = kvClient.get(key);

            // // get the value from CompletableFuture
            // GetResponse response = getFuture.get();

            // // delete the key
            // kvClient.delete(key).get();    
        
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("opreste");
    }

    public static int getIndex(String line){
        int i = 0;
        for (; i < line.length(); ++i) {
            if (line.charAt(i) == ',')
                break;
        }
        return i >= line.length() ? -1 : i;
    }

    public static ByteSequence[] getByteSequence(String[] charArr) {
        ByteSequence[] arr = new ByteSequence[charArr.length];
        int i = 0;
        for (String key: charArr) {
            arr[i++] = ByteSequence.from(key.getBytes());
        }
        return arr;
    }

    public static void put(KV kvClient,ByteSequence[] keys,ByteSequence[] values) {
        if (keys.length != values.length) {
            System.out.println("eroare in put. Lungimi diferite chei si valori");
            return;
        }
        int i = 0;
        try {
            for (; i < keys.length; ++i) {
                kvClient.put(keys[i], values[i]).get();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        } catch(ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void delete(KV kvClient,ByteSequence[] keys) {
        int i = 0;
        for (ByteSequence key:keys) {
            kvClient.delete(key);
        }
    }
}
