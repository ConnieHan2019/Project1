public class LLBlock extends Block {

    public int[][] initialBlock() {
        this.block = new int[][]{{0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        return block;
    }

    //建立ZBlock，并且以“z”型初始化
    public LLBlock() {
        this.block = new int[][]{{0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        this.rows = 3;
        this.columns = 3;
        this.addition = 2;
        this.substraction = 0;
    }


    //下一个方块是上一个顺时针旋转90度
    public int[][] nextRotatedBlock() {
        int[][] block = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                block[i][j] = this.block[j][2 - i];//旋转
            }
        }
        return block;
    }
}