package sample;

import com.johanpmeert.JpmBitcoinRpcClient;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println("Printing lowest hashes");
        System.out.println("----------------------");
        JpmBitcoinRpcClient.CoinData btcCoin = JpmBitcoinRpcClient.CoinData.BTC;
        JpmBitcoinRpcClient client = new JpmBitcoinRpcClient(btcCoin);
        int blockCounter = 1;
        int maxBlock = client.GetBlockCount();
        String lowestHash = "FF".repeat(32);
        BigInteger biLowestHash = new BigInteger(lowestHash, 16);
        System.out.println("Max block count: " + maxBlock);
        while (blockCounter < maxBlock) {
            String hash = client.GetBlockHash(blockCounter);
            BigInteger biHash = new BigInteger(hash, 16);
            if (biHash.compareTo(biLowestHash) == -1) {
                lowestHash = hash;
                biLowestHash = biHash;
                System.out.printf("\n    Block %6d : " + lowestHash, blockCounter);
            }
            blockCounter++;
        }
    }
}
