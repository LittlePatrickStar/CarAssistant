package cyy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import android.os.Environment;

import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Checkbox;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;

public class CarAssistant {
	

	
	private long lastTimeFileSize = 0;

	private JFrame frame;
	public JComboBox snList;
	public String SN;
	public TextArea textArea;;
	public static String myCount;
	private Button sn;
	private Button connect;
	private Button open;
	private Button clear;
	private Button getBattery;
	private Button getMemory;
	private Button getLog;
	private Button getMPUVersion;
	private Button getMCUVersion;
	private Button getMAC;
	private Button start;
	private JComboBox  cityList;
	private JComboBox  speedList;
	private JComboBox  airConditioningList;
	private JComboBox  driverList;
	private JComboBox  volumeList;
	private TextField cmdField;
	private TextField times;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private Button save;
	private Panel panel_1;
	private Button tap;
	private Label xlabel;
	private TextField x;
	private Label ylabel;
	private TextField y;
	private TextField time;
	private JComboBox timeType;
	private Button wait;
	private TextField loopTimes;
	private Button endLoop;
	private Button startLoop;
	private Button hardkey;
	private JComboBox hardKeyList;
	private Button run;
	private Button stop;
	private JPanel panel_2;
	private Button screenShot;
	private Button cmd;
	private Panel panel_3;
	private Panel panel_4;
	private TextArea textArea_2;
	private TextArea textArea_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					CarAssistant window = new CarAssistant();
					window.frame.setVisible(true);
					
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					File authority=new File("C:\\authority");
					File record=new File("C:\\authority\\authority.txt");
					if(!authority.exists()) {
						authority.mkdirs();
					}
					if(!record.exists()) {
						record.createNewFile();
						String orignel=df.format(new Date());
						PrintWriter pfp= new PrintWriter(record);
						pfp.print(orignel);
						pfp.close();
					}else {
						InputStreamReader reader = new InputStreamReader(new FileInputStream(record)); 
			            BufferedReader br = new BufferedReader(reader); 
			            String line = "";  
			            while ((line = br.readLine()) != null) {  
			                String[] orignelList=line.split("-");
			                int start=Integer.valueOf(orignelList[1]);
					        String current=df.format(new Date());
					        String[] currentList=current.split("-");
					        int stop=Integer.valueOf(currentList[1]);
					        if((stop-start)>=1) {
									window.frame.dispose();
					       }
			            }  
			           br.close();
			           reader.close();
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarAssistant() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int height=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
		int width=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;

		frame = new JFrame("CarAssistant V1.0---By CYY(Any problem,Please Contact with me,Thanks!WeiChat:chenyuan2919)");
		frame.getContentPane().setEnabled(false);
		frame.setBounds(200, 50, 1037, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 5, 5));
	
		
		JPanel basePanle = new JPanel();
		basePanle.setLayout(null);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setSize(1037, 746);
		basePanle.setPreferredSize(new Dimension(1000, 700));

		scrollPane_1.setViewportView( basePanle );
		frame.getContentPane().add(scrollPane_1);
				
				JPanel TopPanle = new JPanel();
				TopPanle.setBounds(10, 10, 666, 35);
				basePanle.add(TopPanle);
				TopPanle.setLayout(new GridLayout(0, 7, 5, 5));
		
				sn = new Button("SNList:");
				TopPanle.add(sn);
				sn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						snList.removeAllItems();;
            	List<String> snListCont=SN();
            	if(snListCont.size() !=0) {
            		for(int i=0;i<snListCont.size();i++){
                 	   if(!snListCont.get(i).equals(null)){
                 		 snList.addItem(snListCont.get(i));
                          snList.setVisible(true);
                 	   }
                        snList.setSelectedIndex(0); 
                   }
            	}else {
            		JOptionPane.showMessageDialog(frame, "Please Connect Your Devices,Thanks!\n"
            				+ "1.Enable USB Debug:Settings->Development\n"
            				+ "2.Enable ADB Com:echo high > /sys/class/pateo_gpios/usb_id\n",
            				"Notic",JOptionPane.WARNING_MESSAGE); 
            	}
            	
					}
				});
				
				
				snList = new JComboBox();
				TopPanle.add(snList);
				
				connect = new Button("Connect");
				TopPanle.add(connect);
				connect.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(snList.getSelectedItem()==null){
							JOptionPane.showMessageDialog(frame, "Please Select SN Number!", "Notic",JOptionPane.WARNING_MESSAGE); 
						}else {
							if(connect.getLabel()=="Connect") {
								SN=snList.getSelectedItem().toString();
								Thread t2= new Thread(){
						            @Override
									public void run(){
										connect(SN);
						            }
						        };
						        t2.start();
								connect.setLabel("DisConnect");
								snList.setEnabled(false);
								open.setEnabled(true);
								clear.setEnabled(true);
								getBattery.setEnabled(true);
								getMemory.setEnabled(true);
								getLog.setEnabled(true);
								getMPUVersion.setEnabled(true);
								getMCUVersion.setEnabled(true);
								getMAC.setEnabled(true);
								start.setEnabled(true);
								cityList.setEnabled(true);
								speedList.setEnabled(true);
								airConditioningList.setEnabled(true);
								driverList.setEnabled(true);
								volumeList.setEnabled(true);
								save.setEnabled(true);
								cmd.setEnabled(true);
								tap.setEnabled(true);
								startLoop.setEnabled(true);
								endLoop.setEnabled(true);
								hardkey.setEnabled(true);
								hardKeyList.setEnabled(true);
								screenShot.setEnabled(true);
								run.setEnabled(true);
								stop.setEnabled(true);
								wait.setEnabled(true);
								timeType.setEnabled(true);
								ylabel.setEnabled(true);
								xlabel.setEnabled(true);
								textArea.append("Connect adb..."+"\n");
							}else if(connect.getLabel()=="DisConnect") {		
								connect.setLabel("Connect");
								disConnect();
								snList.setEnabled(true);
								open.setEnabled(false);
								clear.setEnabled(false);
								getBattery.setEnabled(false);
								getMemory.setEnabled(false);
								getLog.setEnabled(false);
								getMPUVersion.setEnabled(false);
								getMCUVersion.setEnabled(false);
								getMAC.setEnabled(false);
								start.setEnabled(false);
								cityList.setEnabled(false);
								speedList.setEnabled(false);
								airConditioningList.setEnabled(false);
								driverList.setEnabled(false);
								volumeList.setEnabled(false);
								save.setEnabled(false);
								cmd.setEnabled(false);
								tap.setEnabled(false);
								startLoop.setEnabled(false);
								endLoop.setEnabled(false);
								hardkey.setEnabled(false);
								hardKeyList.setEnabled(false);
								screenShot.setEnabled(false);
								run.setEnabled(false);
								stop.setEnabled(false);
								wait.setEnabled(false);
								timeType.setEnabled(false);
								ylabel.setEnabled(false);
								xlabel.setEnabled(false);
								textArea.append("Killed adb..."+"\n");
							}
							
						
						}
					}
				});
				
				open = new Button("Open");
				TopPanle.add(open);
				open.setEnabled(false);
				open.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Thread t2= new Thread(){
				            @Override
							public void run(){
								  JFileChooser jfc=new JFileChooser();  
							        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
							        int returnVal =jfc.showDialog(new JLabel(), "Ñ¡Ôñ");  
							        File file=jfc.getSelectedFile();  
							        	if(returnVal == JFileChooser.APPROVE_OPTION) {
							        		if(file.getName().contains(".txt")){
							        			try {
													BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
													String line = null;
													while((line = bufr.readLine())!=null) {
														textArea.append(line+"\n");
													}
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}		
							        		}else {
							        			JOptionPane.showMessageDialog(frame, "Please Select txt  file!", "Notic",JOptionPane.WARNING_MESSAGE); 
							        		}
							        	}		
							        	if(returnVal==JFileChooser.CANCEL_OPTION) {  
							     
							            }  
				            }
				        };
				        t2.start();
						
					}
				});
				
				save = new Button("Save");
				save.setEnabled(false);
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Thread t2= new Thread(){
				            @Override
							public void run(){
								  JFileChooser jfc=new JFileChooser();  
							        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
							        int returnVal =jfc.showDialog(new JLabel(), "Ñ¡Ôñ");  
							        File file=jfc.getSelectedFile();  
							        	if(returnVal == JFileChooser.APPROVE_OPTION) {
							        		if( file.getName().contains(".txt")) {
							        			try {
								        			file.createNewFile();
								        			FileWriter fw = new FileWriter(file,true);
								        			fw.write(textArea.getText());
								        			fw.close();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}		
								        	}else {
								        		JOptionPane.showMessageDialog(frame, "Please Input file name with .txt!", "Notic",JOptionPane.WARNING_MESSAGE); 
								        	}
							        	}
							        		if(returnVal==JFileChooser.CANCEL_OPTION) {  
							     
							            }  
				            }
				        };
				        t2.start();
						
						
					}
				});
				TopPanle.add(save);
				
				clear = new Button("Clear");
				TopPanle.add(clear);
				clear.setEnabled(false);
				clear.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						textArea.setText(null);
					}
					
				});
				
				cmd = new Button("CMD");
				cmd.setEnabled(false);
				cmd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Thread thread= new Thread(){
				            @Override
							public void run(){
				            	if(!cmdField.getText().contains("adb")) {
				            		JOptionPane.showMessageDialog(frame, "Wrong adb command!", "Notic",JOptionPane.WARNING_MESSAGE); 
				            	}else {
					    			textArea.append(inputCmd(cmdField.getText()));
				            	}
				            }
				        };
				        thread.start();	
					}
				});
				TopPanle.add(cmd);
				
			
				JScrollPane leftMiddleScrollPane = new JScrollPane();
				leftMiddleScrollPane.setBounds(10, 55, 999, 493);
				basePanle.add(leftMiddleScrollPane);
				
				JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
				leftMiddleScrollPane.setColumnHeaderView(tabbedPane);
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				
				JPanel firstTabPanle = new JPanel();
				tabbedPane.addTab("Command", null, firstTabPanle, null);
				firstTabPanle.setLayout(new GridLayout(0, 3, 0, 0));
				
				getBattery = new Button("GetBattery");
				getBattery.setEnabled(false);
				getBattery.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Thread thread= new Thread(){
				            @Override
							public void run(){
				            	String line="";
								try {
//									Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"shell","dumpsys","battery"});
									Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"shell","screencap","-p","/data/local/tmp/tmp.png"});
									InputStream input=process.getInputStream();
									InputStreamReader reader=new InputStreamReader(input);
									BufferedReader bufferedreader=new BufferedReader(reader);
									while((line=bufferedreader.readLine())!=null){
										textArea.append(line+"\n");
									}
									bufferedreader.close();
									reader.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
				            }
				        };
				        thread.start();
					}
				});
				firstTabPanle.add(getBattery);
				
				getMemory = new Button("GetMemory");
				getMemory.setEnabled(false);
				getMemory.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Thread thread= new Thread(){
				            @Override
							public void run(){
				            	String line="";
								try {
									Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"shell","cat","/proc/meminfo"});
									InputStream input=process.getInputStream();
									InputStreamReader reader=new InputStreamReader(input);
									BufferedReader bufferedreader=new BufferedReader(reader);
									while((line=bufferedreader.readLine())!=null){
										textArea.append(line+"\n");
									}
									bufferedreader.close();
									reader.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
				            }
				        };
				        thread.start();
					}
				});
				firstTabPanle.add(getMemory);
				
				getLog = new Button("GetLog");
				getLog.setEnabled(false);
				getLog.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
		            	if(getLog.getLabel()=="GetLog"){
							Thread thred= new Thread(){
					            @Override
								public void run(){
					            	String line="";
									try {
//										Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"logcat","-c"});
										Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"logcat"});
										InputStream input=process.getInputStream();
										InputStreamReader reader=new InputStreamReader(input);
										BufferedReader bufferedreader=new BufferedReader(reader);
										while((line=bufferedreader.readLine())!=null){
											textArea.append(line+"\n");
										}
										bufferedreader.close();
										reader.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
					            }
					        };
					        thred.start();
			            	getLog.setLabel("StopLog");
		            	}else if(getLog.getLabel()=="StopLog") {
		           		 Thread thread= new Thread(){
					            @Override
								public void run(){
									disConnect();
									textArea.append("Stop Log..."+"\n");
									connect(SN);
					            }
					        };
					        thread.start();
				       		getLog.setLabel("GetLog");
		            	}
					}
				});
				firstTabPanle.add(getLog);
				
				getMCUVersion = new Button("GetMCUVersion");
				getMCUVersion.setEnabled(false);
				getMCUVersion.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Thread thread= new Thread(){
				            @Override
							public void run(){
				            	String line="";
								try {
									Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"shell","cat /sys/class/misc/cis_mcu_mpu/sw_version"});
									InputStream input=process.getInputStream();
									InputStreamReader reader=new InputStreamReader(input);
									BufferedReader bufferedreader=new BufferedReader(reader);
									while((line=bufferedreader.readLine())!=null){
										if(line.contains("MCU SW version")) {
											textArea.append(line+"\n");
										}
									}
									bufferedreader.close();
									reader.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
				            }
				        };
				        thread.start();
					}
				});
				
				getMPUVersion = new Button("GetMPUVersion");
				getMPUVersion.setEnabled(false);
				getMPUVersion.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Thread thread= new Thread(){
				            @Override
							public void run(){
				            	String line="";
								try {
									Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"shell","getprop"});
									InputStream input=process.getInputStream();
									InputStreamReader reader=new InputStreamReader(input,"UTF-8");
									BufferedReader bufferedreader=new BufferedReader(reader);
									while((line=bufferedreader.readLine())!=null){
										if(line.contains("[ro.build.version.incremental]")) {
											textArea.append("MPU Version:"+line+"\n");
										}
										if(line.contains("[ro.vendor.build.date]")) {
											textArea.append("MPU Date:"+line+"\n");
										}
									}
									bufferedreader.close();
									reader.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
				            }
				        };
				        thread.start();
					}
				});
				firstTabPanle.add(getMPUVersion);
				firstTabPanle.add(getMCUVersion);
				
				getMAC = new Button("GetMAC");
				getMAC.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Thread thread= new Thread(){
				            @Override
							public void run(){
				            	String line="";
								try {
									Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"shell","cat /sys/class/net/wlan0/address"});
									InputStream input=process.getInputStream();
									InputStreamReader reader=new InputStreamReader(input);
									BufferedReader bufferedreader=new BufferedReader(reader);
									while((line=bufferedreader.readLine())!=null){
											textArea.append("WLAN MAC:"+line+"\n");
									}
									bufferedreader.close();
									reader.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
				            }
				        };
				        thread.start();
					}
				});
				getMAC.setEnabled(false);
				firstTabPanle.add(getMAC);
				
				JPanel secondTabPanle = new JPanel();
				tabbedPane.addTab("Recognition", null, secondTabPanle, null);
				secondTabPanle.setLayout(new GridLayout(0, 6, 0, 0));
				
				JLabel city = new JLabel("\u573A\u666F\uFF1A");
				city.setHorizontalAlignment(SwingConstants.CENTER);
				secondTabPanle.add(city);
				
				cityList = new JComboBox();
				cityList.setEnabled(false);
				cityList.setModel(new DefaultComboBoxModel(new String[] {"\u57CE\u5E02", "\u9AD8\u901F"}));
				secondTabPanle.add(cityList);
				
				JLabel airConditioning = new JLabel("\u7A7A\u8C03\uFF1A");
				airConditioning.setHorizontalAlignment(SwingConstants.CENTER);
				secondTabPanle.add(airConditioning);
				
				airConditioningList = new JComboBox();
				airConditioningList.setEnabled(false);
				airConditioningList.setModel(new DefaultComboBoxModel(new String[] {"\u4F4E", "\u4E2D", "\u9AD8"}));
				secondTabPanle.add(airConditioningList);
				
				JLabel volume = new JLabel("\u97F3\u91CF\uFF1A");
				volume.setHorizontalAlignment(SwingConstants.CENTER);
				secondTabPanle.add(volume);
				
				volumeList = new JComboBox();
				volumeList.setEnabled(false);
				volumeList.setModel(new DefaultComboBoxModel(new String[] {"1/3", "2/3", "3/3"}));
				secondTabPanle.add(volumeList);
				
				JLabel speed = new JLabel("\u8F66\u901F\uFF1A");
				speed.setHorizontalAlignment(SwingConstants.CENTER);
				secondTabPanle.add(speed);
				
				speedList = new JComboBox();
				speedList.setEnabled(false);
				speedList.setModel(new DefaultComboBoxModel(new String[] {"<=40km/h", "40~60km/h", "60~100km/h", ">=100km/h"}));
				secondTabPanle.add(speedList);
				
				JLabel driver = new JLabel("\u9A7E\u9A76\u5EA7\u4F4D\uFF1A");
				driver.setHorizontalAlignment(SwingConstants.CENTER);
				secondTabPanle.add(driver);
				
				driverList = new JComboBox();
				driverList.setEnabled(false);
				driverList.setModel(new DefaultComboBoxModel(new String[] {"\u4E3B\u9A7E", "\u526F\u9A7E"}));
				secondTabPanle.add(driverList);
				
				times = new TextField();
				times.setBackground(new Color(211, 211, 211));
				times.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
				times.setText("Times");
				secondTabPanle.add(times);
				
					
					start = new Button("Start");
					start.setEnabled(false);
					secondTabPanle.add(start);
					
					JPanel thridPanle = new JPanel();
					tabbedPane.addTab("AutoTest", null, thridPanle, null);
					thridPanle.setLayout(new BoxLayout(thridPanle, BoxLayout.Y_AXIS));
					
					panel_1 = new Panel();
					thridPanle.add(panel_1);
					panel_1.setLayout(new GridLayout(2, 0, 0, 0));
					
					tap = new Button("Tap");
					tap.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(x.getText().equals("") || y.getText().equals("")) {
								JOptionPane.showMessageDialog(frame, "Please Input Location,Thanks!", "Notic",JOptionPane.WARNING_MESSAGE); 
							}else {
								textArea.append("Tap "+x.getText()+" "+y.getText()+"\n");
							}
						}
					});
					tap.setEnabled(false);
					panel_1.add(tap);
					
					xlabel = new Label("X:");
					xlabel.setEnabled(false);
					xlabel.setAlignment(Label.CENTER);
					panel_1.add(xlabel);
					
					x = new TextField();
					panel_1.add(x);
					
					ylabel = new Label("Y:");
					ylabel.setEnabled(false);
					ylabel.setAlignment(Label.CENTER);
					panel_1.add(ylabel);
					
					y = new TextField();
					panel_1.add(y);
					
					startLoop = new Button("StartLoop");
					startLoop.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(loopTimes.getText().equals("")) {
								JOptionPane.showMessageDialog(frame, "Please Input Loop Number,Thanks!", "Notic",JOptionPane.WARNING_MESSAGE); 
							}else {
								textArea.append("StartLoop "+loopTimes.getText()+"\n");
							}
						}
					});
					startLoop.setEnabled(false);
					panel_1.add(startLoop);
					
					loopTimes = new TextField();
					panel_1.add(loopTimes);
					
					endLoop = new Button("EndLoop");
					endLoop.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textArea.append("EndLoop "+"\n");
						}
					});
					endLoop.setEnabled(false);
					panel_1.add(endLoop);
					
					wait = new Button("Wait");
					wait.setEnabled(false);
					wait.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(time.getText().equals("")) {
								JOptionPane.showMessageDialog(frame, "Please Input Wait Times,Thanks!", "Notic",JOptionPane.WARNING_MESSAGE); 
							}else {
								textArea.append("Wait "+time.getText()+" "+timeType.getSelectedItem()+"\n");
							}
						}
					});
					panel_1.add(wait);
					
					timeType = new JComboBox();
					timeType.setEnabled(false);
					timeType.setModel(new DefaultComboBoxModel(new String[] {"Seconds"}));
					panel_1.add(timeType);
					
					time = new TextField();
					panel_1.add(time);
					
					hardkey = new Button("HardKey");
					hardkey.setEnabled(false);
					hardkey.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textArea.append("Press "+" "+hardKeyList.getSelectedItem()+"\n");
						
						}
					});
					panel_1.add(hardkey);
					
					hardKeyList = new JComboBox();
					hardKeyList.setEnabled(false);
					hardKeyList.setModel(new DefaultComboBoxModel(new String[] {"HOME", "BACK", "MENU", "POWER", "VOL+", "VOL-"}));
					panel_1.add(hardKeyList);
					
					screenShot = new Button("ScreenShot");
					screenShot.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							textArea.append("ScreenShot /mnt/sdcard/"+"\n");
		
						}
					});
					screenShot.setEnabled(false);
					panel_1.add(screenShot);
					
					run = new Button("Run");
					run.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Thread t2= new Thread(){
					            @Override
								public void run(){
									List<String> script=Arrays.asList(textArea.getText().split("\n"));
									for(int i=0;i<script.size();i++) {
						            	if(script.get(i).contains("StartLoop")) {
						            		int k=Integer.valueOf(script.get(i).replace("StartLoop ", ""));
						            		List<String> loop = new ArrayList<String>();
						            		while(true) {
						            			if(!script.get(i).contains("StartLoop")) {
						            				loop.add(script.get(i));
						            			}
						            			i++;
						            			if(script.get(i).contains("EndLoop")) {
						            				break;
						            			}
						            		}
						            		for(int z=1;z<=k;z++) {
						            			for(int p=0;p<loop.size();p++) {
						            				runScript(loop.get(p));
						            				System.out.println(loop.get(p));
						            			}
						            		}
						            	}else {
											runScript(script.get(i));
						            	}
									}
					            	
					            	
					            }

					        };
					        t2.start();
						}
					});
					run.setEnabled(false);
					panel_1.add(run);
					
					
					
					stop = new Button("Stop");
					stop.setEnabled(false);
					panel_1.add(stop);
					start.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(start.getLabel().equals("Start")) {
								if(times.getText().equals("Times")) {
									JOptionPane.showMessageDialog(frame, "Please Input Test Times!", "Notic",JOptionPane.WARNING_MESSAGE); 
								}else {
								textArea.append("Ç°ÌáÌõ¼þ£º"+"\n");
								textArea.append("³¡¾°£º"+cityList.getSelectedItem().toString()+"\n");
								textArea.append("¿Õµ÷£º"+airConditioningList.getSelectedItem().toString()+"\n");
								textArea.append("ÒôÁ¿£º"+volumeList.getSelectedItem().toString()+"\n");
								textArea.append("³µËÙ£º"+speedList.getSelectedItem().toString()+"\n");
								textArea.append("¼ÝÊ»×ùÎ»£º"+driverList.getSelectedItem().toString()+"\n");
								textArea.append("²âÊÔ´ÎÊý£º"+times.getText()+"\n");
								Thread t2= new Thread(){
						            @Override
									public void run(){
						            	String line="";
						            	String oldLine="";
						            	int num=1;
										try {
											Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"logcat","-c"});
											Process process=Runtime.getRuntime().exec(new String[]{"adb","-s",SN,"logcat"});
											InputStream input=process.getInputStream();
											InputStreamReader reader=new InputStreamReader(input);
											BufferedReader bufferedreader=new BufferedReader(reader);
											while((line=bufferedreader.readLine())!=null){
												if(line.contains("SpeechWakeUpEngine")) {
													line=line.split("SpeechWakeUpEngine: onWakeup ")[1].split("wakeupWord:")[0];
													if(!oldLine.equals(line) && oldLine=="") {
														textArea.append(line+"+"+num);	
													}else if(!oldLine.equals(line) && oldLine!="") {
														num=1;
														textArea.append("\n"+line+"+"+num);	
													} else if(oldLine.equals(line)) {
														num++;
														textArea.append(" +"+num);
													}
													oldLine=line;
												}
											}
											bufferedreader.close();
											reader.close();
										} catch (IOException e) {
											e.printStackTrace();
										}
						            }
						        };
						        t2.start();
						        start.setLabel("Stop");
						        getBattery.setEnabled(false);
								getMemory.setEnabled(false);
								getLog.setEnabled(false);
								getMPUVersion.setEnabled(false);
								getMCUVersion.setEnabled(false);
								getMAC.setEnabled(false);
								cityList.setEnabled(false);
								speedList.setEnabled(false);
								airConditioningList.setEnabled(false);
								driverList.setEnabled(false);
								volumeList.setEnabled(false);
								save.setEnabled(false);
								cmd.setEnabled(false);
								tap.setEnabled(false);
								startLoop.setEnabled(false);
								endLoop.setEnabled(false);
								hardkey.setEnabled(false);
								hardKeyList.setEnabled(false);
								screenShot.setEnabled(false);
								run.setEnabled(false);
								stop.setEnabled(false);
								wait.setEnabled(false);
								timeType.setEnabled(false);
								ylabel.setEnabled(false);
								xlabel.setEnabled(false);
								connect.setEnabled(false);
								open.setEnabled(false);
								clear.setEnabled(false);
								sn.setEnabled(false);
								}
								}else if(start.getLabel().equals("Stop")){
								 Thread thread= new Thread(){
						            @Override
									public void run(){
										disConnect();
										connect(SN);
										textArea.append("\n");
								        start.setLabel("Stop");
						            }
						        };
						        thread.start();
								start.setLabel("Start");
								getBattery.setEnabled(true);
								getMemory.setEnabled(true);
								getLog.setEnabled(true);
								getMPUVersion.setEnabled(true);
								getMCUVersion.setEnabled(true);
								getMAC.setEnabled(true);
								cityList.setEnabled(true);
								speedList.setEnabled(true);
								airConditioningList.setEnabled(true);
								driverList.setEnabled(true);
								volumeList.setEnabled(true);
								save.setEnabled(true);
								cmd.setEnabled(true);
								tap.setEnabled(true);
								startLoop.setEnabled(true);
								endLoop.setEnabled(true);
								hardkey.setEnabled(true);
								hardKeyList.setEnabled(true);
								screenShot.setEnabled(true);
								run.setEnabled(true);
								stop.setEnabled(true);
								wait.setEnabled(true);
								timeType.setEnabled(true);
								ylabel.setEnabled(true);
								xlabel.setEnabled(true);
								connect.setEnabled(true);
								open.setEnabled(true);
								clear.setEnabled(true);
								sn.setEnabled(true);
							}
						}
					});
					
					textArea = new TextArea();
					leftMiddleScrollPane.setViewportView(textArea);
					textArea.setBackground(Color.BLACK);
					textArea.setForeground(Color.WHITE);
					textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
				
				JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane_1.setBounds(10, 547, 999, 153);
				basePanle.add(tabbedPane_1);
				
				panel_4 = new Panel();
				tabbedPane_1.addTab("Notice", null, panel_4, null);
				panel_4.setLayout(new GridLayout(0, 1, 0, 0));
				
				textArea_2 = new TextArea();
				textArea_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				textArea_2.setText("\u4E94\u83F1\u9879\u76EE\uFF1A\r\n\r\n\u67E5\u770B\u97F3\u91CF\uFF1Aadb shell dumpsys qg.audio_policy\r\n\r\n\u67E5\u770Bmodem\u7248\u672C\uFF1Aadb shell getprop | grep \"gsm.version.baseband\"\r\n\r\n\u67E5\u770B\u5185\u6838\u7248\u672C\uFF1Aadb shell cat /proc/version\r\n\r\n\u67E5\u770Bmcu vin\u7801\uFF1Aadb shell cat sys/class/misc/cis_mcu_mpu/vehicle_vin ");
				textArea_2.setEditable(false);
				panel_4.add(textArea_2);
				
				panel_2 = new JPanel();
				tabbedPane_1.addTab("Note", null, panel_2, null);
				panel_2.setLayout(new GridLayout(0, 1, 0, 0));
				
				textArea_3 = new TextArea();
				textArea_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
				panel_2.add(textArea_3);
				
				panel_3 = new Panel();
				panel_3.setBounds(675, 10, 334, 35);
				basePanle.add(panel_3);
				panel_3.setLayout(new GridLayout(0, 1, 0, 0));
				
				cmdField = new TextField();
				panel_3.add(cmdField);
				cmdField.setText(myCount);
				cmdField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
				cmdField.setBackground(Color.BLACK);
				cmdField.setForeground(Color.WHITE);

	}
	
	public static List<String> SN(){
		List<String> SN1=new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec("adb devices");
			InputStreamReader streamReader=new InputStreamReader(process.getInputStream());
			BufferedReader bufferReader = new BufferedReader(streamReader);
			String line;
			int i=0;
			while((line=bufferReader.readLine()) !=null && line.length() !=0 ){
				if(!line.contains("List")){
					SN1.add(line.substring(0,line.indexOf("device")).replaceAll("\\t", ""));
				}
			}
			bufferReader.close();
			streamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SN1;
	}
	
	public static void connect(String SN){
		inputCmd(new String[]{"adb","-s",SN,"shell"});
	}
	
	public static void disConnect(){
		inputCmd(new String[] {"adb","kill-server"});
	}

	public static String inputCmd(String cmd) {
		String[] cmdList = null;
		if(cmd.contains(" ")&& cmd!=null) {
			cmdList=cmd.split(" ");
		}else {
			cmdList=new String[] {"adb","dd"};
		}
		String list="";
		String line="";
			try {
				Process process=Runtime.getRuntime().exec(cmdList);
				process.waitFor();
				InputStream input=process.getInputStream();
				InputStreamReader reader=new InputStreamReader(input);
				BufferedReader bufferedreader=new BufferedReader(reader);

				while((line=bufferedreader.readLine())!=null){
					list=list+line+"\n";
				}
				bufferedreader.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return list;	
	}
	
	public static String inputCmd(String[] cmdArray){		
		String list="";
		String line="";
			try {
				Process process=Runtime.getRuntime().exec(cmdArray);
				InputStream input=process.getInputStream();
				InputStreamReader reader=new InputStreamReader(input);
				BufferedReader bufferedreader=new BufferedReader(reader);

				while((line=bufferedreader.readLine())!=null){
					list=list+line+"\n";
				}
				bufferedreader.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return list;	
	}

	public void runScript(String script) {
			if(script.contains("Tap")) {
        		String x=script.split(" ")[1];
        		String y=script.split(" ")[2];
        		inputCmd("adb shell input tap "+x+" "+y);
        	}else if(script.contains("Wait")) {
        		Integer time=Integer.valueOf(script.split(" ")[1]);
        		 try {
						TimeUnit.SECONDS.sleep(time);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	}else if(script.contains("Press")) {
        		if(script.contains("HOME")) {
        			inputCmd("adb shell input keyevent 3");
        		}
        		if(script.contains("BACK")) {
        			inputCmd("adb shell input keyevent 4");
        		}
        		if(script.contains("MENU")) {
        			inputCmd("adb shell input keyevent 82");
        		}
        		if(script.contains("POWER")) {
        			inputCmd("adb shell input keyevent 26");
        		}
        		if(script.contains("VOL+")) {
        			inputCmd("adb shell input keyevent 24");
        		}
        		if(script.contains("VOL-")) {
        			inputCmd("adb shell input keyevent 25");
        		}
        	}
			
	}
	
		 
	
}
