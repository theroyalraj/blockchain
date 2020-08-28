package blockchain.model;

import blockchain.util.StringUtil;

public class Block {
    private final long id, timeStamp;
    //this will be the data for the transaction value
    //Transaction transaction;
    private final String prevHash;
    private String hash;


    public Block(final long id, long timeStamp, final String prevBlockHash) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.prevHash = prevBlockHash;
        this.hash = calculateHash(prevBlockHash);
    }

    public String calculateHash(String prevBlockHash) {
        return StringUtil.applySha256(id + " " + timeStamp + prevBlockHash);
    }

    public long getId() {
        return id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevBlockHash() {
        return prevHash;
    }

    @Override
    public String toString() {

        return "Block:" + "\n" +
                "Id: " + id + "\n" +
                "Timestamp: " + timeStamp + "\n" +
                "Hash of the previous block:" + "\n" +
                prevHash + "\n" +
                "Hash of the block:" + "\n" +
                hash;
    }

}
