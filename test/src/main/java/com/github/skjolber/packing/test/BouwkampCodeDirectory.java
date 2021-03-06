package com.github.skjolber.packing.test;

import java.util.ArrayList;
import java.util.List;

public class BouwkampCodeDirectory {

	private static final BouwkampCodeDirectory directory;
	
	static {
		BouwkampCodeDirectory d = new BouwkampCodeDirectory();
		
		BouwkampCodeParser parser = new BouwkampCodeParser();
		
		try {
			d.simpleImperfectSquaredRectangles.add(parser.parse("/simpleImperfectSquaredRectangles/o9sisr.bkp"));
			d.simpleImperfectSquaredRectangles.add(parser.parse("/simpleImperfectSquaredRectangles/o12sisrs.bkp"));
			d.simpleImperfectSquaredRectangles.add(parser.parse("/simpleImperfectSquaredRectangles/o13sisrs.bkp"));
			
			d.simpleImperfectSquaredSquares.add(parser.parse("/simpleImperfectSquaredSquares/o13siss.bkp"));
			d.simpleImperfectSquaredSquares.add(parser.parse("/simpleImperfectSquaredSquares/o15siss.bkp"));
			d.simpleImperfectSquaredSquares.add(parser.parse("/simpleImperfectSquaredSquares/o16siss.bkp"));

			d.simplePerfectSquaredRectangles.add(parser.parse("/simplePerfectSquaredRectangles/o9spsr.bkp"));
			d.simplePerfectSquaredRectangles.add(parser.parse("/simplePerfectSquaredRectangles/o10spsr.bkp"));
			d.simplePerfectSquaredRectangles.add(parser.parse("/simplePerfectSquaredRectangles/o11spsr.bkp"));
			d.simplePerfectSquaredRectangles.add(parser.parse("/simplePerfectSquaredRectangles/o12spsr.bkp"));
			d.simplePerfectSquaredRectangles.add(parser.parse("/simplePerfectSquaredRectangles/o13spsr.bkp"));
		} catch(Exception e) {
			throw new BouwkampCodeException(e);
		}
		directory = d;
	}
	
	public static BouwkampCodeDirectory getInstance() {
		return directory;
	}
	
	protected List<BouwkampCodes> simpleImperfectSquaredRectangles = new ArrayList<>();
	protected List<BouwkampCodes> simpleImperfectSquaredSquares = new ArrayList<>();
	protected List<BouwkampCodes> simplePerfectSquaredRectangles = new ArrayList<>();
	
	private BouwkampCodeDirectory() {
	}
	
	public List<BouwkampCodes> getSimpleImperfectSquaredRectangles() {
		return simpleImperfectSquaredRectangles;
	}
	public void setSimpleImperfectSquaredRectangles(List<BouwkampCodes> simpleImperfectSquaredRectangles) {
		this.simpleImperfectSquaredRectangles = simpleImperfectSquaredRectangles;
	}
	public List<BouwkampCodes> getSimpleImperfectSquaredSquares() {
		return simpleImperfectSquaredSquares;
	}
	public void setSimpleImperfectSquaredSquares(List<BouwkampCodes> simpleImperfectSquaredSquares) {
		this.simpleImperfectSquaredSquares = simpleImperfectSquaredSquares;
	}
	public List<BouwkampCodes> getSimplePerfectSquaredRectangles() {
		return simplePerfectSquaredRectangles;
	}
	public void setSimplePerfectSquaredRectangles(List<BouwkampCodes> simplePerfectSquaredRectangles) {
		this.simplePerfectSquaredRectangles = simplePerfectSquaredRectangles;
	}

	public BouwkampCode codesForCount(int count, String name) {
		List<BouwkampCodes> codes = codesForCount(count);
		for(BouwkampCodes code : codes) {
			for (BouwkampCode bouwkampCode : code.getCodes()) {
				if(bouwkampCode.getName().equals(name)) {
					return bouwkampCode;
				}
			}
		}
		return null;
	}

	public List<BouwkampCodes> codesForCount(int count) {
		List<BouwkampCodes> result = new ArrayList<>();
		for(BouwkampCodes code : simpleImperfectSquaredRectangles) {
			if(code.getCodes().get(0).getSquare().size() == count) {
				result.add(code);
			}
		}
		for(BouwkampCodes code : simpleImperfectSquaredSquares) {
			if(code.getCodes().get(0).getSquare().size() == count) {
				result.add(code);
			}
		}
		for(BouwkampCodes code : simplePerfectSquaredRectangles) {
			if(code.getCodes().get(0).getSquare().size() == count) {
				result.add(code);
			}
		}
		return result;
	}
	
	
	
}
