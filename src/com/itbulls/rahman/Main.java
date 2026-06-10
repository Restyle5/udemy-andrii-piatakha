package com.itbulls.rahman;

import chapter.Chapter;
import chapter.ChapterEighteen;
import chapter.ChapterNineteenth;
import chapter.ChapterTwentyOne;
import chapter.ChapterTwentyTwo;

public class Main {
	public static void main(String args[])
	{
		System.out.println("");
//		final Chapter c = new ChapterEighteen();
//		final Chapter c = new ChapterNineteenth();
//		final Chapter c = new ChapterTwentyOne();
		final Chapter c = new ChapterTwentyTwo();
		
		c.execute();
		System.out.println(c.getChapterName());
		System.out.println(c.getNotes());
	}
}
	