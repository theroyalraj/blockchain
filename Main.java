package blockchain;

import blockchain.model.BlockChain;


public class Main {
    public static void main(String[] args) throws Exception {
        BlockChain blockChain = new BlockChain();
        for (int i = 0; i < 10; i++) {
            blockChain.addBlock();
        }
        blockChain.validateChain();
        System.out.println(blockChain.toString(5));
    }

}
