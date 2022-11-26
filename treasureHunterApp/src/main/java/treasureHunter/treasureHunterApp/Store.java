package treasureHunter.treasureHunterApp;

public class Store {

	public static final int COST_UPGRADE_HOOK = 100;
	public static final int MAX_LENGTH = 280;
	public static final int IMPROVE_LENGTH = 10;
	
	public static final int COST_UPGRADE_ENGINE = 200;
	public static final int MAX_POWER = 3;
	
	public static final int FUEL_COST = 80;
	public static final int RECHARGE_FUEL = 200;
	public static final int MAX_FUEL = 2000;
	
	/*
	 * DEVUELVE TRUE SI EL LARGO DEL GANCHO NO SUPERA LA LONGITUD MAXIMA
	 */
	public boolean noMaxLength(int length) {
		return(length < MAX_LENGTH);
	}
	
	/*
	 * DEVUELVE TRUE SI EL MOTOR ALCANZO LA POTENCIA MAXIMA
	 */
	public boolean noMaxPower(int power) {
		return(power < MAX_POWER);
	}
	
	/*
	 * DEVUELVE TRUE SI LA CAPACIDAD DEL TANQUE ES SUFICIENTE PARA RECARGAR COMBUSTIBLE
	 */
	public boolean noMaxFuel(float fuel) {
		return(fuel < (MAX_FUEL-RECHARGE_FUEL));
	}
	
	/*
	 * DEVUELVE TRUE SI EL BALANCE SUPERA O IGUALA AL PRECIO RECIBIDO
	 * POR PARAMETRO
	 */
	public boolean canBuy(int balance, int price) {
		return(balance >= price);
	}
	
	/*
	 * RECIBE AL JUGADOR Y EL PRECIO DE UNA COMPRA 
	 * DEVUELVE TRUE SI EL JUGADOR PUDO PAGAR
	 */
	public boolean pay(Player player, int price) {
		if(canBuy(player.getBalance(), price)) {
			player.deductBalance(price);
			return true;
		}
		return false;
	}
	
	/*
	 * INCREMENTA LA LONGITUD DEL GANCHO DESCONTANDOLE AL JUGADOR
	 * EL COSTO DE LA MEJORA
	 */
	public void improveHook(Player player, Hook hook) {
		
		if(noMaxLength(hook.getLength()) && pay(player, COST_UPGRADE_HOOK) ) {
			hook.increaseLength(IMPROVE_LENGTH);
		}
	}
	
	/*
	 * INCREMENTA LA POTENCIA DEL MOTOR DESCONTANDOLE AL JUGADOR
	 * EL COSTO DE LA MEJORA
	 */
	public void improveEngine(Player player, Engine engine) {
		
		if(noMaxPower(engine.getPower()) && pay(player, COST_UPGRADE_ENGINE)) {
			engine.improvePower();
		}
	}
	
	/*
	 * INCREMENTA EL COMBUSTIBLE DEL MOTOR DESCONTANDOLE AL JUGADOR
	 * EL COSTO DEL MISMO
	 */
	public void buyFuel(Player player, Engine engine) {
		
		if(noMaxFuel(engine.getFuel()) && pay(player, FUEL_COST)) {
			engine.accreditFuel(RECHARGE_FUEL);
		}
	}
}