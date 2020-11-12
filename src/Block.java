public class Block {
    protected int[][] block;
    protected int rows;
    protected int columns;
    protected int addition;//旋转列中心和行中心之和
    protected int substraction;//旋转行中心和列中心之差

    public int[][]getBlock(){
        return block;

    }
    public int[][]initialBlock(){

        return block;
    }


    public Block()
    {this.rows = rows;
     this.columns = columns;
     this.block = block;
     this.addition = addition;
     this.substraction = substraction;


    }


    //下一个方块是上一个顺时针旋转90度
    public int[][] nextRotatedBlock(){
        int[][]block = new int[rows][columns];
        for(int i = 0; i <rows; i++){
            for(int j = 0; j< columns; j++){
                block[i][j] = this.block[j+ substraction][addition- i];//旋转
            }
        }
        return block;
    }
    //旋转90度
    public void rotate(){
        block = nextRotatedBlock();//nextRotatedBlock 的返回值是block

    }
}
