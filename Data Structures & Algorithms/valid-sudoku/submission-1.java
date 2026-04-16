class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len= board.length;
        Set[] row=new HashSet[len];
        Set[] col=new HashSet[len];
        Set[] boxes=new HashSet[len];

        for(int i=0;i<len;i++){
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            boxes[i]=new HashSet<>();
        }

        for(int r=0;r<len;r++){
            for(int c=0;c<len;c++){
                char num=board[r][c];
                if(num=='.') continue;

                int boxId=(r/3)*3+(c/3);

                if(row[r].contains(num) || col[c].contains(num) || boxes[boxId].contains(num)){
                    return false;
                }

                row[r].add(num);
                col[c].add(num);
                boxes[boxId].add(num);
            }
        }

        return true;
    }
}
