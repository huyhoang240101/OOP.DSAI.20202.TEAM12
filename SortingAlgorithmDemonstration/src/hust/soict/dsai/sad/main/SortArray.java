package hust.soict.dsai.sad.main;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import hust.soict.dsai.sad.algoritms.ISortAlgorithm;

public class SortArray extends JPanel {
	
	public static final int DEFAULT_WINDOW_HEGHT = 1280;
	public static final int DEFAULT_WINDOW_WIDTH = 720;
	public static final int DEFAULT_BAR_WIDTH = 10;
	
	private static final double BAR_HEIGHT_PERCENT = 512.0/720.0;
	
	private ArrayList<Integer> array;
	private int NUM_BAR;
	private final int[] barColor;
    private String algorithmName = "";
    private ISortAlgorithm algorithm;
    private long algorithmDelay = 0;
    
    private JSpinner spinner;
	
	private int arrayChange = 0; // Number of changes to the array the current algorithm has taken so far
	
	public SortArray(ArrayList<Integer> arr) {
		setBackground(Color.DARK_GRAY);
		this.array = arr;
		NUM_BAR = arr.size();
		barColor = new int[NUM_BAR];
		for (int i = 0; i < NUM_BAR; i++) {
			barColor[i] = 0;
		}
		spinner = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        spinner.addChangeListener((event) -> {
            algorithmDelay = (Integer) spinner.getValue();
            algorithm.setDelay(algorithmDelay);
        });
        add(spinner,BorderLayout.LINE_START);
	}
	
	public int getArraySize() {
		return array.size();
	}
	
	public int getValue(int index) {
		return array.get(index);
	}
	
	public int getMaxValue() {
		return Collections.max(array);
	}
	
	public void finaliseUpdate(long msDelay, boolean isStep) {
		repaint();
        try {
            Thread.sleep(msDelay);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (isStep) {
        	arrayChange++;
        }
	}
	
	public void swap(int index1, int index2, long msDelay, boolean isStep) {
		Collections.swap(array, index1, index2);
		
		barColor[index1] = 100;
		barColor[index2] = 100;
		
		finaliseUpdate(msDelay, isStep);
	}
	
	public void updateSingle(int index, int value, long msDelay, boolean isStep) {
		array.set(index, value);
		barColor[index] = 100;
		
		finaliseUpdate(msDelay, isStep);
		repaint();
	}
	
	public void highlightArray() {
		for (int i = 0; i < getArraySize(); i++) {
			updateSingle(i, getValue(i), 5, false);
		}
	}
	
	public void resetColor() {
		for (int i = 0; i < getArraySize(); i++) {
			barColor[i] = 0;
		}
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D panelGraphics = (Graphics2D) g.create();

		try
		{
			Map<RenderingHints.Key, Object> renderingHints = new HashMap<>();
			renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			panelGraphics.addRenderingHints(renderingHints);
			panelGraphics.setColor(Color.WHITE);
			panelGraphics.setFont(new Font("Monospaced", Font.BOLD, 20));
			panelGraphics.drawString(" Current algorithm: " + algorithmName, 10, 30);
			panelGraphics.drawString("Current step delay: " + algorithmDelay + "ms", 10, 55);
			panelGraphics.drawString("     Array Changes: " + arrayChange, 10, 80);
			panelGraphics.drawString("     Array: " + array, 10, 105);

			drawBar(panelGraphics);
		} finally {
        	panelGraphics.dispose();
        }
	}
	
	public void drawBar(Graphics2D panelGraphic) {
		int widthMargin = 10;
		int barWidth = ((getWidth() - 2*widthMargin) / getArraySize()) - widthMargin;
		int bufferedImageWidth = getWidth();
		int bufferedImageHeight = getHeight();
		
		if (bufferedImageHeight > 0 && bufferedImageWidth > 0) {
			if (bufferedImageWidth < 256) {
				bufferedImageWidth = 256;
			}
			double maxValue = getMaxValue();
			
			BufferedImage bufferedImage = new BufferedImage(bufferedImageWidth, bufferedImageHeight, BufferedImage.TYPE_INT_ARGB);
			makeBufferedImageTransparent(bufferedImage);
			Graphics2D bufferedGraphic = null;
			
			try {
				bufferedGraphic = bufferedImage.createGraphics();
				
				for (int x = 0; x < getArraySize(); x++) {
					double currentValue = getValue(x);
					double percentOfMax = currentValue / maxValue;
					double heightPercentOfPanel = percentOfMax * BAR_HEIGHT_PERCENT;
					int heightMargin = 30;
					int barHeight = (int) (heightPercentOfPanel * (((double) getHeight() - 2*heightMargin)));
					int xBegin = ((barWidth + widthMargin)  * x) + widthMargin;
					int yBegin = getHeight() - barHeight - heightMargin;
					
					int val = barColor[x] * 2;
					if (val > 190) {
						bufferedGraphic.setColor(new Color(255- val, 255, 255 - val));
					}
					else {
						bufferedGraphic.setColor(new Color(255, 255 - val, 255 - val));
					}
					bufferedGraphic.setStroke(new BasicStroke(5));
					bufferedGraphic.drawRect(xBegin, yBegin, barWidth, barHeight);
					bufferedGraphic.setFont(new Font("Monospaced", Font.BOLD, 40));
					bufferedGraphic.drawString((int) currentValue + "", xBegin, yBegin);
					if (barColor[x] > 0) {
						barColor[x] -= 5;
					}
				}
			}
			finally {
				if (bufferedGraphic != null) {
					bufferedGraphic.dispose();
				}
			}
			panelGraphic.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
		}
	}
	
	private void makeBufferedImageTransparent(BufferedImage image) {
		Graphics2D bufferedGraphic = null;
		try {
			bufferedGraphic = image.createGraphics();
			bufferedGraphic.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
			bufferedGraphic.fillRect(0, 0, image.getWidth(), image.getHeight());
			bufferedGraphic.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
		
		}
		finally {
			if (bufferedGraphic != null) {
				bufferedGraphic.dispose();
			}
		}
	}
	
	public void setName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    
    public void setAlgorithm(ISortAlgorithm algorithm) {
        this.algorithm = algorithm;
        algorithmDelay = algorithm.getDelay();
        spinner.setValue((int) algorithm.getDelay());
    }
    
    public long getAlgorithmDelay(){
        return algorithmDelay;
    }
}