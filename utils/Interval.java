package utils;

public class Interval {
	public int begin, end;
	// public boolean S = false;
	public int tempNo;

	public Interval(int tempNo, int begin, int end) {
		this.begin = begin;
		this.end = end;
		this.tempNo = tempNo;
	}

	public boolean compare(Interval b) {
		if (begin == b.begin)
			return end < b.end;
		return begin < b.begin;
	}
}