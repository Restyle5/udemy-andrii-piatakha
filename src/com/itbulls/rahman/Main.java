package com.itbulls.rahman;

import chapter.Chapter;
import chapter.ChapterEighteen;
import chapter.ChapterNineteenth;
import chapter.ChapterTwentyOne;

public class Main {
	public static void main(String args[])
	{
		System.out.println("");
//		final Chapter c = new ChapterEighteen();
//		final Chapter c = new ChapterNineteenth();
		final Chapter c = new ChapterTwentyOne();
		
		c.execute();
		System.out.println(c.getChapterName());
		System.out.println(c.getNotes());
	}
}
