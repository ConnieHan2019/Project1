public class TBlock extends Block {
    //建立ZBlock，并且以“z”型初始化
    public int[][]initialBlock() {
        this.block = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}};
        return block;
    }
    public TBlock()
    {this.block = new int[][]{{0,1,0},{1,1,1},{0,0,0}};
    this.rows = 3;
    this.columns = 3;
    this.addition = 2;
    this.substraction = 0;

    }



    //旋转90度

}
