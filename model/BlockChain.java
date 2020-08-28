package blockchain.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BlockChain {
    private static final String FIRST_BLOCK = "0";
    private final HashMap<String, Block> blockChainMap = new HashMap<>();
    private Block lastBlock = null;

    public void addBlock() {
        String prevHash = (lastBlock != null) ? lastBlock.getHash() : FIRST_BLOCK;
        lastBlock = new Block(blockChainMap.size() + 1, System.currentTimeMillis(), prevHash);
        blockChainMap.put(lastBlock.getHash(), lastBlock);
    }

    public void validateChain() throws Exception {
        if (blockChainMap.isEmpty()) return;
        Block checkedBlock = lastBlock;
        do {
            String prevHash = checkedBlock.getPrevBlockHash();
            if (prevHash.equals(FIRST_BLOCK))
                return;
            checkedBlock = blockChainMap.get(prevHash);
        } while (checkedBlock != null);
        throw new Exception("INVALID CHAIN");

    }

    private List<Block> getChain() {
        List<Block> blockChain = new LinkedList<>();
        Block block = lastBlock;
        for (int i = 0; i < blockChainMap.size(); i++) {
            blockChain.add(0, block);
            block = blockChainMap.get(block.getPrevBlockHash());
        }
        return blockChain;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Block block : getChain()) {
            stringBuilder.append(block.toString()).append("\n\n");
        }
        return stringBuilder.toString();
    }

    public String toString(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Block block : getChain().subList(0, count)) {
            stringBuilder.append(block.toString()).append("\n\n");
        }
        return stringBuilder.toString();
    }

    private Block block;

    Block getBlock() {
        return block;
    }

    void setBlock(Block block) {
        this.block = block;
    }
}
