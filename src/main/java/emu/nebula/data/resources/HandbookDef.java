package emu.nebula.data.resources;

import emu.nebula.data.BaseDef;
import emu.nebula.data.ResourceType;
import emu.nebula.data.ResourceType.LoadPriority;
import lombok.Getter;

@Getter
@ResourceType(name = "Handbook.json", loadPriority = LoadPriority.LOW)
public class HandbookDef extends BaseDef {
    private int Id;
    private int Index;
    private int Type;
    
    @Override
    public int getId() {
        return Id;
    }
    
    @Override
    public void onLoad() {
        
    }
}
