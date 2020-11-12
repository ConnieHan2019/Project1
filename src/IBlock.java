public class IBlock extends Block {

    public int[][] initialBlock() {
        this.block = new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0},{0,0,0,0}};
        return block;
    }

    //建立ZBlock，并且以“z”型初始化
    public IBlock(){
        this.block = new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0},{0,0,0,0}};
        this.rows = 4;
        this.columns = 4;
        this.addition = 3;
        this.substraction = 0;


    }

}
