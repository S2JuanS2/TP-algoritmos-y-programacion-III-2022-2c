package treasureHunter.treasureHunterApp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class View {
	
	public static HashMap<String, Image> images;
	public static HashMap<String, AudioClip> sounds;
	private static Group group;
	private static Scene sceneGame;
	private static Scene sceneMenu;
	private static Canvas canvasMenu;
	private static Canvas canvasGame;
	private static GraphicsContext graphicsGame;
	private static GraphicsContext graphicsMenu;
	private static Button btnBuyFuel;
	private static Button btnBuyImproveHook;
	private static Button btnBuyImprovePower;
	private static Button btnSave;
	private static Button btnPause;
	private static Button btnBack;
	private static Button btnMusicPause;
	private static Button btnNewGame;
	private static Button btnContinueGame;
	private static Button btnExitGame;
	private static Button btnHelp;
	private static Button btnAbout;
	private static Button btnContinue; 
	private static Button btnPlayGame;
	private static Label lbHelp;
	private static Label lbAbout;
	private static Label lbPause;
	private static TextField name;
	private boolean moveLeft = false;
	private boolean moveRight = true;
	private boolean action = false;
	private boolean goDown = false;
	private boolean goUp = false;
	private boolean stop = false;
	
	public View() {
		
		
		images = new HashMap<String,Image>();
		sounds = new HashMap<String,AudioClip>();
		loadImages();
		loadSounds();
		
	}
	
	public void loadImages() {
		images.put("oro", new Image(getClass().getResource("/res/oro.png").toExternalForm()));
		images.put("fondo",new Image(getClass().getResource("/res/fondo.png").toExternalForm()));
		images.put("hook", new Image(getClass().getResource("/res/hook.png").toExternalForm()));
		images.put("hook2", new Image(getClass().getResource("/res/hook2.png").toExternalForm()));
		images.put("hook3", new Image(getClass().getResource("/res/hook3.png").toExternalForm()));
		images.put("diamond", new Image(getClass().getResource("/res/diamante.png").toExternalForm()));
		images.put("iron", new Image(getClass().getResource("/res/hierro.png").toExternalForm()));
		images.put("calavera", new Image(getClass().getResource("/res/calavera.png").toExternalForm()));
		images.put("ruby", new Image(getClass().getResource("/res/ruby.png").toExternalForm()));
		images.put("gas", new Image(getClass().getResource("/res/gasolina.png").toExternalForm()));
		images.put("save", new Image(getClass().getResource("/res/save.png").toExternalForm()));
		images.put("hand", new Image(getClass().getResource("/res/mano.png").toExternalForm()));
		images.put("fondoMenu", new Image(getClass().getResource("/res/fondoMenu.png").toExternalForm()));
		images.put("logo", new Image(getClass().getResource("/res/logo.png").toExternalForm()));
		images.put("nuevaPartida", new Image(getClass().getResource("/res/nuevaPartida.png").toExternalForm()));
		images.put("continuarPartida", new Image(getClass().getResource("/res/continuarPartida.png").toExternalForm()));
		images.put("salir", new Image(getClass().getResource("/res/salir.png").toExternalForm()));
		images.put("handHover", new Image(getClass().getResource("/res/manoHover.png").toExternalForm()));
		images.put("moneda", new Image(getClass().getResource("/res/moneda.png").toExternalForm()));
		images.put("cofre", new Image(getClass().getResource("/res/cofre.png").toExternalForm()));
		images.put("planta", new Image(getClass().getResource("/res/planta.png").toExternalForm()));
		images.put("cadena", new Image(getClass().getResource("/res/cadena.png").toExternalForm()));
		images.put("llave", new Image(getClass().getResource("/res/llave.png").toExternalForm()));
		images.put("saco", new Image(getClass().getResource("/res/saco.png").toExternalForm()));
		images.put("piedra", new Image(getClass().getResource("/res/piedra.png").toExternalForm()));
		images.put("caldero", new Image(getClass().getResource("/res/caldero.png").toExternalForm()));
		images.put("pergamino", new Image(getClass().getResource("/res/pergamino.png").toExternalForm()));
		images.put("victoria", new Image(getClass().getResource("/res/victoria.png").toExternalForm()));
		images.put("derrota", new Image(getClass().getResource("/res/derrota.png").toExternalForm()));
		images.put("accept", new Image(getClass().getResource("/res/accept.png").toExternalForm()));
		images.put("help", new Image(getClass().getResource("/res/ayuda.png").toExternalForm()));
		images.put("about", new Image(getClass().getResource("/res/about.png").toExternalForm()));
		images.put("aboutText", new Image(getClass().getResource("/res/aboutText.png").toExternalForm()));
		images.put("helpText", new Image(getClass().getResource("/res/ayudaText.png").toExternalForm()));
		images.put("back", new Image(getClass().getResource("/res/volver.png").toExternalForm()));
		images.put("pause", new Image(getClass().getResource("/res/pause.png").toExternalForm()));
		images.put("musicPause", new Image(getClass().getResource("/res/musicPause.png").toExternalForm()));
		images.put("pergaminoName", new Image(getClass().getResource("/res/pergaminoName.png").toExternalForm()));
		images.put("play", new Image(getClass().getResource("/res/play.png").toExternalForm()));
		
	}
	
	public void loadSounds() {		
		sounds.put("soundClick", new AudioClip(getClass().getResource("/res/clickMenu.wav").toExternalForm()));
		sounds.put("soundWin", new AudioClip (getClass().getResource("/res/win.wav").toExternalForm()));
		sounds.put("soundDefeat", new AudioClip (getClass().getResource("/res/loser.wav").toExternalForm()));
		sounds.put("soundBuy", new AudioClip(getClass().getResource("/res/buy.wav").toExternalForm()));
		sounds.put("soundNoFuel", new AudioClip(getClass().getResource("/res/noFuel.wav").toExternalForm()));
		sounds.put("soundChain", new AudioClip(getClass().getResource("/res/cadena.wav").toExternalForm()));
		sounds.put("soundAmbience", new AudioClip(getClass().getResource("/res/ambience.wav").toExternalForm()));
		sounds.put("soundCollision", new AudioClip(getClass().getResource("/res/collision.wav").toExternalForm()));
		sounds.put("soundCollect", new AudioClip(getClass().getResource("/res/collect.wav").toExternalForm()));
		sounds.put("soundSave", new AudioClip(getClass().getResource("/res/save.wav").toExternalForm()));
	}
	
	
	public void refreshCanvas(TreasureHunterGame game) {
		
		graphicsGame.clearRect(0,0,canvasGame.getWidth(),canvasGame.getHeight());
		graphicsGame.drawImage(images.get("fondo"), 0, 0);
		game.getHook().draw(graphicsGame);
		
		if(!game.getTreasure().isEmpty()) {
			Iterator<Treasure> it = game.getTreasure().iterator();
			while(it.hasNext()) {
				it.next().draw(graphicsGame);
			}
		}
		
		if(game.getPlayer().getTreasure() != null) {
			graphicsGame.drawImage(images.get(game.getPlayer().getTreasure().getNameImage()), game.getHook().getPosition().getX(), game.getHook().getPosition().getY()+10);
		}
		
		graphicsGame.setFill(Color.GRAY);
		graphicsGame.fillRect(20, 9, 2000/5, 11);
		graphicsGame.setFill(Color.DARKRED);
		graphicsGame.fillRect(20, 9, game.getHook().getEngine().getFuel()/5, 11);
		graphicsGame.setFill(Color.WHITE);
		graphicsGame.fillText(String.valueOf(game.getHook().getEngine().getFuel()), 20, 19);
		graphicsGame.setFill(Color.WHITE);
		graphicsGame.setFont(Font.font(14));
		graphicsGame.fillText("Player: " + game.getPlayer().getName(), 450, 18);
		graphicsGame.fillText("Balance: $" + String.valueOf(game.getPlayer().getBalance()) + ",00", 450, 33);
		graphicsGame.setFill(Color.BURLYWOOD);
		graphicsGame.fillRect(game.getHook().getPosition().getX()+14, 76, 3, game.getHook().getPosition().getY()-75);
		graphicsGame.fillRect(0, 77, 640, 2);

		graphicsGame.setFill(Color.DARKRED);
		for (int i = 10; i < 640; i = i + 40) {
			graphicsGame.fillRect(i, game.getHook().getLength()+105, 20, 2);				
		}
		
	}

	public void generateButtons() {
		
		BackgroundImage backgroundImageGas = new BackgroundImage(images.get("gas"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundGas = new Background(backgroundImageGas);
		
		BackgroundImage backgroundImageSave = new BackgroundImage(images.get("save"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundSave = new Background(backgroundImageSave);
		
		BackgroundImage backgroundImageImproveHook = new BackgroundImage(images.get("cadena"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundImproveHook = new Background(backgroundImageImproveHook);
		
		BackgroundImage backgroundImageImproveEngine = new BackgroundImage(images.get("llave"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundImproveEngine = new Background(backgroundImageImproveEngine);
		
		BackgroundImage backgroundImageVolver = new BackgroundImage(images.get("back"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundVolver = new Background(backgroundImageVolver);
	
		BackgroundImage backgroundImageMusicPause = new BackgroundImage(images.get("musicPause"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundMusicPause = new Background(backgroundImageMusicPause);
	
		BackgroundImage backgroundImagePause = new BackgroundImage(images.get("pause"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundPause = new Background(backgroundImagePause);
		
		BackgroundImage backgroundImagePlay = new BackgroundImage(images.get("play"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
																	BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundPlay = new Background(backgroundImagePlay);

		btnBuyFuel.setLayoutX(20);
		btnBuyFuel.setLayoutY(30);
		btnBuyFuel.setPrefSize(28, 32);
		btnBuyFuel.setBackground(backgroundGas);
		btnBuyFuel.setCursor(new ImageCursor(images.get("handHover")));
		
		btnSave.setLayoutX(60);
		btnSave.setLayoutY(30);
		btnSave.setPrefSize(28, 32);
		btnSave.setBackground(backgroundSave);
		btnSave.setCursor(new ImageCursor(images.get("handHover")));
		
		btnBuyImproveHook.setLayoutX(100);
		btnBuyImproveHook.setLayoutY(30);
		btnBuyImproveHook.setPrefSize(32, 32);
		btnBuyImproveHook.setBackground(backgroundImproveHook);
		btnBuyImproveHook.setCursor(new ImageCursor(images.get("handHover")));
		
		btnBuyImprovePower.setLayoutX(140);
		btnBuyImprovePower.setLayoutY(30);
		btnBuyImprovePower.setPrefSize(32, 32);
		btnBuyImprovePower.setBackground(backgroundImproveEngine);
		btnBuyImprovePower.setCursor(new ImageCursor(images.get("handHover")));
		
		btnPause.setLayoutX(570);
		btnPause.setLayoutY(3);
		btnPause.setPrefSize(32, 32);
		btnPause.setScaleX(0.7);
		btnPause.setScaleY(0.7);
		btnPause.setBackground(backgroundPause);
		btnPause.setCursor(new ImageCursor(images.get("handHover")));
		
		btnMusicPause.setLayoutX(600);
		btnMusicPause.setLayoutY(3);
		btnMusicPause.setPrefSize(32, 32);
		btnMusicPause.setScaleX(0.7);
		btnMusicPause.setScaleY(0.7);
		btnMusicPause.setBackground(backgroundMusicPause);
		btnMusicPause.setCursor(new ImageCursor(images.get("handHover")));
		
		btnBack.setLayoutX(600);
		btnBack.setLayoutY(32);
		btnBack.setPrefSize(32,32);
		btnBack.setScaleX(0.8);
		btnBack.setScaleY(0.8);
		btnBack.setBackground(backgroundVolver);
		btnBack.setCursor(new ImageCursor(images.get("handHover")));
		
		btnPlayGame.setLayoutX(270);
		btnPlayGame.setLayoutY(20);
		btnPlayGame.setPrefSize(120,50);
		btnPlayGame.setScaleX(0.8);
		btnPlayGame.setScaleY(0.8);
		btnPlayGame.setBackground(backgroundPlay);
		btnPlayGame.setCursor(new ImageCursor(images.get("handHover")));
		
		lbPause.setLayoutX(320);
		lbPause.setLayoutY(90);
		
	}
	
	public void playGame(Stage stage, TreasureHunterGame game) {
		
		group = new Group();
		btnBuyFuel = new Button();
		btnSave = new Button();
		btnBuyImproveHook = new Button();
		btnBuyImprovePower = new Button();
		btnPause = new Button();
		btnMusicPause = new Button();
		btnBack = new Button();
		btnPlayGame = new Button();
		
		lbPause = new Label("PAUSA");
		
		sceneGame = new Scene(group, 640, 480);
		canvasGame = new Canvas(640, 480);
		group.getChildren().add(canvasGame);
		group.getChildren().add(btnBuyFuel);
		group.getChildren().add(btnSave);
		group.getChildren().add(btnBuyImproveHook);
		group.getChildren().add(btnBuyImprovePower);
		group.getChildren().add(btnPause);
		group.getChildren().add(btnMusicPause);
		group.getChildren().add(btnBack);
		group.getChildren().add(btnPlayGame);
	
		graphicsGame = canvasGame.getGraphicsContext2D();
		stage.setScene(sceneGame);
		stage.setTitle("Treasure Hunter");
		stage.setResizable(false);
		stage.show();
		
		sceneGame.setCursor(new ImageCursor(images.get("hand")));
		
		generateButtons();
		
		var t = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				
				refreshCanvas(game);
				
				if(game.getHook().thereIsFuel()){
					
					if(moveLeft && !action) {
						game.getHook().moveLeft();
						if(!game.getHook().collisionBorderMap()) {
							moveLeft = false;
							moveRight = true;
						}
					}
					if(moveRight && !action) {
						game.getHook().moveRight(610);
						if(!game.getHook().collisionBorderMap(610)) {
							moveLeft = true;
							moveRight = false;
						}
					}
					if(goDown) {
						game.goDownHook();
						if(!game.getHook().canKeepGoingDown() || game.collisionTreasure()) {
							sounds.get("soundCollision").play();
							goDown = false;
							goUp = true;
						}
					}if((!game.collisionTreasure()) && goUp && (!game.getHook().initialPosition())) {
						game.getHook().goUp();
					}else if(game.getHook().initialPosition()){
						if(game.getPlayer().getTreasure() != null) {
							sounds.get("soundCollect").play();
							game.collect();							
						}
						sounds.get("soundChain").stop();
						action = false;
						goUp = false;
					}
				}else {
					sounds.get("soundNoFuel").play();
					sounds.get("soundChain").stop();
					this.stop();
					if(btnBuyFuel.isDisable()) {
						sounds.get("soundAmbience").stop();
						sounds.get("soundDefeat").play();
						this.stop();
						btnBuyFuel.setDisable(true);
						btnBuyImproveHook.setDisable(true);
						btnBuyImprovePower.setDisable(true);
						btnSave.setDisable(true);
						graphicsGame.drawImage(images.get("pergamino"), 160, 160);
						graphicsGame.drawImage(images.get("derrota"), 200, 240);
						endScene(stage, game);
					}
				}
				if(!game.getStore().canBuy(game.getPlayer().getBalance(), Store.FUEL_COST) || !game.getStore().noMaxFuel(game.getHook().getEngine().getFuel())) {
					btnBuyFuel.setDisable(true);
				}else {
					btnBuyFuel.setDisable(false);
				}
				if(!game.getStore().canBuy(game.getPlayer().getBalance(), Store.COST_UPGRADE_HOOK) || !game.getStore().noMaxLength(game.getHook().getLength())) {
					btnBuyImproveHook.setDisable(true);
				}else {
					btnBuyImproveHook.setDisable(false);
				}
				if(!game.getStore().canBuy(game.getPlayer().getBalance(), Store.COST_UPGRADE_ENGINE) || !game.getStore().noMaxPower(game.getHook().getEngine().getPower())) {
					btnBuyImprovePower.setDisable(true);
				}else {
					btnBuyImprovePower.setDisable(false);
				}
				if(action) {
					btnSave.setDisable(true);
				}else {
					btnSave.setDisable(false);
				}
				
				if(!game.getHook().thereIsFuel()) {
					btnBuyImproveHook.setDisable(true);
					btnBuyImprovePower.setDisable(true);
				}
				
				if(game.getTreasure().isEmpty() && game.getHook().initialPosition()) {
				
					sounds.get("soundAmbience").stop();
					sounds.get("soundChain").stop();
					sounds.get("soundWin").play();
					this.stop();
					btnBuyFuel.setDisable(true);
					btnBuyImproveHook.setDisable(true);
					btnBuyImprovePower.setDisable(true);
					btnSave.setDisable(true);
					graphicsGame.drawImage(images.get("pergamino"), 160, 160);
					graphicsGame.drawImage(images.get("victoria"), 200, 240);
					endScene(stage, game);
				}
				
				if(!game.inGame()) {
					btnBuyFuel.setDisable(true);
					btnBuyImproveHook.setDisable(true);
					btnBuyImprovePower.setDisable(true);
					btnSave.setDisable(true);
					btnPause.setDisable(true);
				}
			}	
		};
		
		btnBuyFuel.setDisable(true);
		btnBuyImproveHook.setDisable(true);
		btnBuyImprovePower.setDisable(true);
		btnPause.setDisable(true);
		refreshCanvas(game);
		
		btnPlayGame.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				group.getChildren().remove(btnPlayGame);
				btnPause.setDisable(false);
				t.start();
					
					
			}
			
			
		});
		
		
		sceneGame.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.E && !action && !stop && game.getHook().thereIsFuel() && !group.getChildren().contains(btnPlayGame)) {
					sounds.get("soundChain").play();
					goDown = true;
					action = true;
				}
			}
		});
		
		btnBuyFuel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(game.inGame()) {
					sounds.get("soundBuy").play();
					t.start();
					game.getStore().buyFuel(game.getPlayer(), game.getHook().getEngine());
					refreshCanvas(game);
				}
			}
			
			
		});
		
		btnBuyImproveHook.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(game.inGame()) {
					sounds.get("soundBuy").play();
					game.getStore().improveHook(game.getPlayer(), game.getHook());
					refreshCanvas(game);
				}
			}
			
			
		});
		
		btnBuyImprovePower.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(game.inGame()) {
					sounds.get("soundBuy").play();
					game.getStore().improveEngine(game.getPlayer(), game.getHook());
					refreshCanvas(game);
				}
			}
			
			
		});
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					if(!action) {
						
						try {
							sounds.get("soundSave").play();
							game.saveGame();
						} catch (IOException e) {
							e.printStackTrace();
						}
						refreshCanvas(game);
					}
			}
		});
		
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					t.stop();
					sounds.get("soundChain").stop();
					sounds.get("soundAmbience").stop();
					goDown = false;
					goUp = false;
					stop = false;
					mainMenu(stage, game);
			}
		});
		
		btnPause.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					if(!stop) {
						sounds.get("soundChain").stop();
						group.getChildren().add(lbPause);
						btnBuyFuel.setDisable(true);
						btnBuyImproveHook.setDisable(true);
						btnBuyImprovePower.setDisable(true);
						stop = true;
						t.stop();
					}else {
						group.getChildren().remove(lbPause);
						btnBuyFuel.setDisable(false);
						btnBuyImproveHook.setDisable(false);
						btnBuyImprovePower.setDisable(false);
						stop = false;
						t.start();
					}
			}
		});
		
		btnMusicPause.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
					sounds.get("soundAmbience").stop();
			}
		});
	}
	
	public void mainMenu(Stage stage, TreasureHunterGame game) {
		
		BackgroundImage backgroundImageNewGame = new BackgroundImage(images.get("nuevaPartida"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundNewGame = new Background(backgroundImageNewGame);

		BackgroundImage backgroundImageContinueGame = new BackgroundImage(images.get("continuarPartida"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundContinueGame = new Background(backgroundImageContinueGame);
		
		BackgroundImage backgroundImageExit = new BackgroundImage(images.get("salir"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundExit = new Background(backgroundImageExit);
		
		BackgroundImage backgroundImageHelp = new BackgroundImage(images.get("help"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundHelp = new Background(backgroundImageHelp);

		BackgroundImage backgroundImageAbout = new BackgroundImage(images.get("about"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundAbout = new Background(backgroundImageAbout);
		
		group = new Group();
		btnNewGame = new Button();
		btnContinueGame = new Button();
		btnExitGame = new Button();
		btnHelp = new Button();
		btnAbout = new Button();
		
		btnNewGame.setPrefSize(190, 22);
		btnNewGame.setBackground(backgroundNewGame);
		btnNewGame.setCursor(new ImageCursor(images.get("handHover")));
		btnContinueGame.setPrefSize(190, 22);
		btnContinueGame.setBackground(backgroundContinueGame);
		btnContinueGame.setCursor(new ImageCursor(images.get("handHover")));
		btnExitGame.setPrefSize(60, 22);
		btnExitGame.setBackground(backgroundExit);
		btnExitGame.setCursor(new ImageCursor(images.get("handHover")));
		btnHelp.setPrefSize(120, 22);
		btnHelp.setBackground(backgroundHelp);
		btnHelp.setCursor(new ImageCursor(images.get("handHover")));
		btnAbout.setPrefSize(120, 22);
		btnAbout.setBackground(backgroundAbout);
		btnAbout.setCursor(new ImageCursor(images.get("handHover")));
		
		sceneMenu = new Scene(group, 640, 480);
		canvasMenu = new Canvas(640, 480);
		group.getChildren().add(canvasMenu);
		group.getChildren().add(btnNewGame);
		group.getChildren().add(btnContinueGame);
		group.getChildren().add(btnExitGame);
		group.getChildren().add(btnHelp);
		group.getChildren().add(btnAbout);
		graphicsMenu = canvasMenu.getGraphicsContext2D();
		stage.setScene(sceneMenu);
		stage.setTitle("Treasure Hunter");
		stage.setResizable(false);
		stage.show();
		
		sceneMenu.setCursor(new ImageCursor(images.get("hand")));
		
		graphicsMenu.drawImage(images.get("fondoMenu"), 0, 0);
		graphicsMenu.drawImage(images.get("logo"), 50, 30);
		btnNewGame.setLayoutX(240);
		btnNewGame.setLayoutY(260);
		btnContinueGame.setLayoutX(240);
		btnContinueGame.setLayoutY(300);
		btnHelp.setLayoutX(240);
		btnHelp.setLayoutY(340);
		btnAbout.setLayoutX(240);
		btnAbout.setLayoutY(380);
		btnExitGame.setLayoutX(240);
		btnExitGame.setLayoutY(420);
		
		sounds.get("soundAmbience").play();
		
		btnNewGame.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				game.reset();
				sounds.get("soundClick").play();
				game.generateTreasures();
				group.getChildren().remove(btnNewGame);
				group.getChildren().remove(btnContinueGame);
				group.getChildren().remove(btnHelp);
				group.getChildren().remove(btnAbout);
				group.getChildren().remove(btnExitGame);
				nameScene(stage, game);
			}
			
		});
		
		File archivoP = new File(Persistence.FILE_PLAYER);
		File archivoH = new File(Persistence.FILE_HOOK);
		File archivoT = new File(Persistence.FILE_TREASURE);
		if( !(archivoP.exists() && archivoH.exists() && archivoT.exists()) ) {
			btnContinueGame.setDisable(true);
			btnNewGame.setDisable(true);
		}else {
			btnContinueGame.setDisable(false);
		}
		
		btnContinueGame.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				try {
					game.setTreasure(game.getSnapshot().loadTreasures());
					game.setPlayer(game.getSnapshot().loadPlayer());
					game.setHook(game.getSnapshot().loadHook());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				sounds.get("soundClick").play();
				playGame(stage, game);
				
			}
			
		});
		
		btnExitGame.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				sounds.get("soundClick").play();
				System.exit(0);
				
			}
			
		});
		
		btnHelp.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				btnNewGame.setDisable(false);
				group.getChildren().remove(btnNewGame);
				group.getChildren().remove(btnContinueGame);
				group.getChildren().remove(btnHelp);
				group.getChildren().remove(btnAbout);
				group.getChildren().remove(btnExitGame);
				sounds.get("soundClick").play();
				helpScene();
				
			}
			
		});
		
		btnAbout.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				group.getChildren().removeAll();
				sounds.get("soundClick").play();
				group.getChildren().remove(btnNewGame);
				group.getChildren().remove(btnContinueGame);
				group.getChildren().remove(btnHelp);
				group.getChildren().remove(btnAbout);
				group.getChildren().remove(btnExitGame);
				aboutScene();
				
			}
			
		});
		
	}
	
	public void aboutScene() {
		
		BackgroundImage backgroundImageContinue = new BackgroundImage(images.get("accept"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundContinue = new Background(backgroundImageContinue);
		
		BackgroundImage backgroundImageAboutText = new BackgroundImage(images.get("aboutText"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundAboutText = new Background(backgroundImageAboutText);
		
		lbAbout = new Label();
		btnContinue = new Button();
		group.getChildren().add(btnContinue);
		group.getChildren().add(lbAbout);
		btnContinue.setBackground(backgroundContinue);
		lbAbout.setBackground(backgroundAboutText);
		lbAbout.setLayoutX(150);
		lbAbout.setLayoutY(300);
		lbAbout.setPrefSize(310, 300);
		btnContinue.setLayoutX(520);
		btnContinue.setLayoutY(410);
		btnContinue.setPrefSize(28,32);
		btnContinue.setCursor(new ImageCursor(images.get("handHover")));
		
		btnContinue.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				sounds.get("soundClick").play();
				group.getChildren().remove(btnContinue);
				group.getChildren().remove(lbAbout);
				group.getChildren().add(btnNewGame);
				group.getChildren().add(btnContinueGame);
				group.getChildren().add(btnHelp);
				group.getChildren().add(btnAbout);
				group.getChildren().add(btnExitGame);
				
			}
			
		});
		
	}
	
	public void helpScene() {
		
		BackgroundImage backgroundImageContinue = new BackgroundImage(images.get("accept"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundContinue = new Background(backgroundImageContinue);
		
		BackgroundImage backgroundImageHelpText = new BackgroundImage(images.get("helpText"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
														BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundHelpText = new Background(backgroundImageHelpText);
		
		lbHelp = new Label();
		btnContinue = new Button();
		group.getChildren().add(btnContinue);
		group.getChildren().add(lbHelp);
		btnContinue.setBackground(backgroundContinue);
		lbHelp.setBackground(backgroundHelpText);
		lbHelp.setLayoutX(100);
		lbHelp.setLayoutY(300);
		lbHelp.setPrefSize(500, 110);
		btnContinue.setLayoutX(520);
		btnContinue.setLayoutY(410);
		btnContinue.setPrefSize(28,32);
		btnContinue.setCursor(new ImageCursor(images.get("handHover")));
		
		btnContinue.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				sounds.get("soundClick").play();
				group.getChildren().remove(btnContinue);
				group.getChildren().remove(lbHelp);
				group.getChildren().add(btnNewGame);
				group.getChildren().add(btnContinueGame);
				group.getChildren().add(btnHelp);
				group.getChildren().add(btnAbout);
				group.getChildren().add(btnExitGame);
			}
			
		});
		
	}
	
	public void nameScene(Stage stage, TreasureHunterGame game) {
		
		BackgroundImage backgroundImageContinue = new BackgroundImage(images.get("accept"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundContinue = new Background(backgroundImageContinue);
		
		BackgroundImage backgroundImagePergaminoName = new BackgroundImage(images.get("pergaminoName"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
															BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundPergaminoName = new Background(backgroundImagePergaminoName);
			
		name = new TextField("Nombre");
	
		btnContinue = new Button();
		group.getChildren().add(btnContinue);
		group.getChildren().add(name);
		name.setLayoutX(150);
		name.setLayoutY(280);
		name.setBackground(backgroundPergaminoName);
		name.setPrefSize(300,150);
		name.setAlignment(Pos.CENTER);
		btnContinue.setBackground(backgroundContinue);
		btnContinue.setLayoutX(520);
		btnContinue.setLayoutY(410);
		btnContinue.setPrefSize(28,32);
		btnContinue.setCursor(new ImageCursor(images.get("handHover")));
		

		
		btnContinue.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				game.getPlayer().setName(name.getText());
				sounds.get("soundClick").play();
				playGame(stage, game);
				
			}
			
		});
		
	}
	
	public void endScene(Stage stage, TreasureHunterGame game) {
		
		BackgroundImage backgroundImageContinue = new BackgroundImage(images.get("accept"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
														BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		Background backgroundContinue = new Background(backgroundImageContinue);
		
		btnContinue = new Button();
		group.getChildren().add(btnContinue);
		btnContinue.setBackground(backgroundContinue);
		btnContinue.setLayoutX(420);
		btnContinue.setLayoutY(340);
		btnContinue.setPrefSize(28,32);
		btnContinue.setCursor(new ImageCursor(images.get("handHover")));
		
		btnContinue.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				sounds.get("soundClick").play();
				mainMenu(stage, game);
				
			}
			
		});
	}	
}
