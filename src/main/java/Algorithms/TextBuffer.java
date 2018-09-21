package Algorithms;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdStats;

import java.util.function.Consumer;

public class TextBuffer {

    private Stack<Character> leftText;
    private Stack<Character> rightText;

    public TextBuffer() {
        this.leftText = new Stack<>() ;
        this.rightText = new Stack<>();
    }

    public void insert(char[] chars){

        for (char c: chars)
            leftText.push(c);
    }

    public void insert(char c){

        leftText.push(c);
    }

    public char delete(){
        assert leftText.size() > 0 : "No more to delete";

        return leftText.pop();
    }

    public void left(int k){
        assert leftText.size() > 0 : "Can't move left";

        for (int i = 0; i < k; i++) {
            rightText.push(leftText.pop());
        }
    }

    public void right(int k){
        assert rightText.size() > 0 : "Can't move right";

        for (int i = 0; i < k; i++) {
            leftText.push(rightText.pop());
        }
    }

    public int size(){

        return leftText.size() + rightText.size();
    }

    private void testPrint(){

        StringBuilder text = new StringBuilder();

        rightText.iterator().forEachRemaining(new Consumer<Character>() {
            @Override
            public void accept(Character character) {
                text.append(character);
            }
        });

        text.append('|');
        leftText.iterator().forEachRemaining(new Consumer<Character>() {
            @Override
            public void accept(Character character) {
                text.append(character);
            }
        });

        System.out.println(text.reverse().toString());
    }

    public static void main(String[] args) {

        TextBuffer tBuffer = new TextBuffer();

        while(true){

            String input = StdIn.readLine();

            if (input.toCharArray().length == 1 && input.toCharArray()[0] == 'd')
                tBuffer.delete();
            else
                if (input.toCharArray().length == 1 && input.toCharArray()[0] == 'l')
                    tBuffer.left(1);
                else
                    if (input.toCharArray().length == 1 && input.toCharArray()[0] == 'r')
                        tBuffer.right(1);
                    else
                        tBuffer.insert(input.toCharArray());

            tBuffer.testPrint();
        }
    }
}
