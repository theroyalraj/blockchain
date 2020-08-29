package blockchain;

import blockchain.model.BlockChain;

import java.util.Scanner;


public class Main {
    public static int DIFFICULTY = 5;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        BlockChain blockChain = new BlockChain();
        System.out.print("Enter how many zeros the hash must start with: ");
        DIFFICULTY = sc.nextInt();
        for (int i = 0; i < 10; i++) {
            blockChain.addBlock();
        }
        blockChain.validateChain();

        System.out.println(blockChain.toString(5));
    }

}
