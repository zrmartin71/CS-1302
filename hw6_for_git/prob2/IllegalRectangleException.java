package prob2;

public class IllegalRectangleException extends RuntimeException {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String msg;
		private double width;
		private double height;
		private double area;

		public IllegalRectangleException(String msg, double width, double height, double area) {
			width= getWidth();
			height= getHeight();
			msg= getMsg();
			area= getArea();
		}
		
		public double getWidth() {
			return this.width;
		}
		
		public double getHeight() {
			return this.height;
		}
		
		public double getArea() {
			return this.area;
		}
		
		public String getMsg() {
			return this.msg;
		}
}
