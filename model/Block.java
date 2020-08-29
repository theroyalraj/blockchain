package blockchain.model;

import blockchain.Main;
import blockchain.util.StringUtil;

public class Block {
    private final long id, timeStamp;
    //this will be the data for the transaction value
    //Transaction transaction;
    private final String prevHash;
    private String hash;
    private final Long duration;
    private int magicNumber;


    public Block(final long id, long timeStamp, final String prevBlockHash) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.prevHash = prevBlockHash;
        this.hash = calculateHash(prevBlockHash);

        String starter = "0".repeat(Math.max(0, Main.DIFFICULTY));
        long start = System.currentTimeMillis();

        magicNumber = 0;
        this.hash = calculateHash(magicNumber + (id + prevHash + timeStamp));
        while (!this.hash.startsWith(starter)) {
            magicNumber++;
            this.hash = calculateHash(magicNumber + (id + prevHash + timeStamp));
        }
        this.duration = System.currentTimeMillis() - start;

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

    public String getPrevBlockHash() {
        return prevHash;
    }

    @Override
    public String toString() {

        return "\nBlock:\nId: " + this.id +
                "\nTimestamp: " + this.timeStamp +
                "\nMagic number: " + this.magicNumber +
                "\nHash of the previous block:\n" + this.prevHash +
                "\nHash of the block:\n" + this.hash +
                "\nBlock was generating for " + this.duration / 100 + " seconds";
    }

}
