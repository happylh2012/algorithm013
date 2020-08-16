递归
模板
def recursion(level,param1,param2,...):
    #recursion terminator
    if level>MAX_LEVEL:
        process_result
        return
     #process logic in current level
     process(level,data...)
     #drill down
     self.recursion(level+1,p1,...)
     #reverse the current level status if needed

public void recur(int level,int param){
    //termintor
    if(level>MAX_LEVEL){
        //process result
        return;
    }
    //process current logic
    process(level,param);
    //drill down
    recur(level:level+1,newParam);
    //restore current status
}
思维要点
1、不要人肉递归
2、找到最近最简方法，将其拆解成可重复解决问题（最近重复子问题）
3、数学归纳法

