public class LBlock extends Block {
    public int[][]getBlock(){
        return block;

    }
    public int[][]initialBlock(){
        this.block = new int[][]{{1,0,0},{1,1,1},{0,0,0}};
        return block;
    }

    //建立ZBlock，并且以“z”型初始化
    public LBlock()
    { this.block = new int[][]{{1,0,0},{1,1,1},{0,0,0}};
    this.rows = 3;
    this.columns = 3;
    this.addition = 2;
    this.substraction = 0;
    }

}
