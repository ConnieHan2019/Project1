public class ZBlock extends Block{
    public int[][]initialBlock(){
        this.rows = 3;
        this.block = new int[][]{{1,1,0},{0,1,1},{0,0,0}};
        return block;
    }

    //建立ZBlock，并且以“z”型初始化
    public ZBlock()
    {this.block = new int[][]{{1,1,0},{0,1,1},{0,0,0}};
    this.rows = 3;
     this.columns = 3;
     this.substraction = 0;
     this.addition = 2;

    }

}
