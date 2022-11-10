package treasureHunter;

import java.io.File;
import java.io.IOException;

public class TreasureHunter{

	public static final java.util.Scanner keyboard = new java.util.Scanner(System.in);
	public static final java.io.PrintStream screen = new java.io.PrintStream(System.out);
	
	public static final String YES = "S";
	public static final String NO = "N";
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		boolean correctOpt = false;
		Snapshot persistence = new Snapshot(null,null);
		TreasureHunterGame treasureHunterGame = new TreasureHunterGame();
			
		screen.print("TREASURE HUNTER\n");
		screen.print("Deseas continuar la partida? (S o N):");
		String optContinue = keyboard.nextLine();
			
		while((!correctOpt)) {
				
			switch(optContinue) {
			case NO:
				screen.print("Ingrese nombre del personaje:"); 
				treasureHunterGame.getPlayer().setName(keyboard.nextLine());
				treasureHunterGame.generateTreasures();
				screen.print("\n");
				correctOpt = true;
				break;
			case YES:
				File archivoP = new File(Persistence.FILE_PLAYER);
				File archivoH = new File(Persistence.FILE_HOOK);
				File archivoT = new File(Persistence.FILE_TREASURE);
				if( !(archivoP.exists() && archivoH.exists() && archivoT.exists()) ) {
					screen.print("Ninguna partida encontrada\n");
					screen.print("Deseas continuar la partida? (S o N):");
					optContinue = keyboard.nextLine();
					break;
				}
				treasureHunterGame.setPlayer(persistence.loadPlayer());
				treasureHunterGame.setHook(persistence.loadHook());
				treasureHunterGame.setTreasure(persistence.loadTreasures());
				correctOpt = true;
				break;	
			default:
				screen.print("Opcion incorrecta\n");
				screen.print("Deseas continuar la partida? (S o N):");
				optContinue = keyboard.nextLine();
			}
		}
		treasureHunterGame.start(persistence);						
	}
}
