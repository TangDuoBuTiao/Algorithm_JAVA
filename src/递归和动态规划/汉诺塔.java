package 递归和动态规划;

public class 汉诺塔 {

    /*
     * 移动x轴上的n个盘子到z轴上，以y作为辅助轴，保存大小顺序不变（假设盘子从上到下依次为1到n）
     * param  n: 盘子个数
     * Param  x: x轴
     * param  y: y轴，辅助轴
     * param  z: z轴
     */
    public void hanoi(int n, char x, char y, char z) {
        if(n == 1){
            move(x, 1, z);
        }
        //若想将n号盘放到z轴上，那么必须先将（1，...，n-1）号盘移动到y轴上，此时z轴作为辅助轴。
        hanoi(n-1, x, z, y);
        //然后移动n号盘到z轴上
        move(x, n, z);
        //最后将y轴上的（1，...，n-1）号盘移动到z轴上，此时x轴作为辅助轴。
        hanoi(n-1, y, x, z);
    }
    /*
     * 移动一个编号为number的盘子从x轴到y轴
     * param x: x轴
     * param number: 盘子编号
     * param y: y轴
     */
    public void move(char x, int number, char y){

    }
}
