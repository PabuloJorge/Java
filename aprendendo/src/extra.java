
public class extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
for (int x = 1; x <= 10; x++) {
	for (int y = 1; y <= 10; y++) {
		for (int z = 1; z <= 10; z++) {
			System.out.println("x = "+x+" Y = "+y+" Z = "+z+ " RESULTADO: "+cubo(x,y,z));
	}
}
	}

}
	public static boolean cubo (int x, int y, int z) {
		int s = x*x*x + y*y*y + z*z*z;
		if (s==42)
			return true;
		return false;
	}
}
