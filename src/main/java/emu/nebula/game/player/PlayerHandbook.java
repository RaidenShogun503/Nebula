package emu.nebula.game.player;

import emu.nebula.proto.Public.HandbookInfo;
import lombok.Getter;

@Getter
public class PlayerHandbook {
    private int type;
    private long[] data;
    
    public PlayerHandbook(int type) {
        this.type = type;
        this.data = new long[1];
    }
    
    public void setBit(int index) {
        int longArrayOffset = (int) Math.floor((index - 1) / 64D);
        int bytePosition = ((index - 1) % 64);
        
        if (longArrayOffset >= this.data.length) {
            var oldData = this.data;
            this.data = new long[longArrayOffset + 1];
            System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        }
        
        this.data[longArrayOffset] |= (1L << bytePosition);
    }
    
    public byte[] toByteArray() {
        byte[] array = new byte[this.getData().length * 8];

        for (int i = 0; i < this.getData().length; i++) {
            long value = this.getData()[i];
            
            for (int x = 7; x >= 0; x--) {
                array[(i * 8) + x] = (byte) (value & 0xFF);
                value >>= Byte.SIZE;
            }
        }
        
        return array;
    }
    
    // Proto
    
    public HandbookInfo toProto() {
        var proto = HandbookInfo.newInstance()
                .setType(this.getType())
                .setData(this.toByteArray());
        
        return proto;
    }
}
