import java.util.Random;
import java.util.Scanner;


public class Game2048 {
	private static int array[][];
	private static Scanner user_input ;
	
	public static void main(String args[]){
		user_input = new Scanner( System.in );
		array = new int[4][4];
		start();
	}
	
	public static void start(){
		
		if(game() == 1){
			System.out.println("Kazandınız");
		}else{
			System.out.println("Kaybettiniz");
		}
		
	}
	
	public static int game(){
		
		while(true){
			
			generateRandom();
			generateRandom();
			print();
			if(play() == 0){
				return 2;
			}
			
			switch(checkGame()){
			
				case 0: break;
				case 1: return 1;
				case 2: return 2;
				
			}
		}
	}
	
	public static int play(){
		int input = 0;
		System.out.println("Yukarı: 1 Sağa: 2 Aşağı: 3 Sola: 4 oyunu bitirmek için: 0 a basınız");
		input = user_input.nextInt();
		switch(input){
		
		case 0: return 0;
		case 1: up(); break;
		case 2: right(); break;
		case 3: down(); break;
		case 4: left(); break;
		
		}
		
		return 1;
		
	}
	
	public static void up(){
		for(int i=1;i<4;i++){
			for(int j=0;j<4;j++){
				shift1(i,j);
			}
		}
	}
	
	public static void right(){
		for(int j=3;j>=0;j--){
			for(int i=0;i<4;i++){
				shift2(i,j);
			}
		}
	}
	
    public static void down(){
    	for(int i=3;i>=0;i--){
			for(int j=0;j<4;j++){
				shift3(i,j);
			}
		}
	}
    
    public static void left(){
    	for(int j=1;j<4;j++){
			for(int i=0;i<4;i++){
				shift4(i,j);
			}
		}
	}
    
    public static int shift1(int i , int j){
    	
    	if(i>0){
    		
    		if(array[i-1][j] == 0){
    			
    			array[i-1][j] = array[i][j];
    			array[i][j] = 0;
    			shift1(i-1,j);
    			
    		}else if(array[i][j] == array[i-1][j]){
    			
    			array[i-1][j] = array[i][j]*2;
    			array[i][j] = 0;
    			return 0;
    			
    		}else{
    			return 0;
    		}
    		
    	}else{
    		return 0;
    	}
    	return 0;
    }
    public static int shift2(int i , int j ){
    	
    	if(j<3){
    		
    		if(array[i][j+1] == 0){
    			
    			array[i][j+1] = array[i][j];
    			array[i][j] = 0;
    			shift2(i,j+1);
    			
    		}else if(array[i][j] == array[i][j+1]){
    			
    			array[i][j+1] = array[i][j]*2;
    			array[i][j] = 0;
    			return 0;
    			
    		}else{
    			return 0;
    		}
    		
    	}else{
    		return 0;
    	}
    	return 0;
    }
    public static int shift3(int i , int j){
    	
    	if(i<3){
    		
    		if(array[i+1][j] == 0){
    			
    			array[i+1][j] = array[i][j];
    			array[i][j] = 0;
    			shift3(i+1,j);
    			
    		}else if(array[i][j] == array[i+1][j]){
    			
    			array[i+1][j] = array[i][j]*2;
    			array[i][j] = 0;
    			return 0;
    			
    		}else{
    			
    			return 0;
    			
    		}
    		
    	}else{
    		
    		return 0;
    		
    	}
    	
    	return 0;
    	
    }
    
    public static int shift4(int i , int j ){
    	
    	if(j>0){
    		
    		if(array[i][j-1] == 0){
    			
    			array[i][j-1] = array[i][j];
    			array[i][j] = 0;
    			shift4(i,j-1);
    			
    		}else if(array[i][j] == array[i][j-1]){
    			
    			array[i][j-1] = array[i][j]*2;
    			array[i][j] = 0;
    			return 0;
    			
    		}else{
    			
    			return 0;
    			
    		}
    		
    	}else{
    		
    		return 0;
    		
    	}
    	
    	return 0;
    	
    }
	
	public static int checkGame(){
		
		int count = 0;
		
		for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				if(array[i][j] >= 2048){
					return 1;
				}
				if(array[i][j] == 0){
					count++;
				}
			}
		}
		if(count > 2)
			return 0;
			return 2;
	}
	
	public static void generateRandom(){
		int x;
		int y;
		Random generator = new Random();
		
		while(true){
			
			x = generator.nextInt(4);
			y = generator.nextInt(4);
			if(array[x][y] == 0)
			break;
			
		}
		
		array[x][y] = generator.nextInt(2) + 1;
		array[x][y] *= 2;
	}
	
	public static void print(){
		System.out.println("");
		for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				if(array[i][j] == 0)
					System.out.print(". ");
				else
					System.out.print(array[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	
}