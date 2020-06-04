package ExTest;

public class Korea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person pEleStu = new ElementStu();// 사람 - 학생 - 초등학생
		Person pGWor = new GoverWorker();//  사람 - 직장인 - 공무원
		System.out.println(pEleStu); // ElementStu
		System.out.println(pGWor);	// GoverWorker
		
		System.out.println(pEleStu instanceof Person); //t
		System.out.println(pGWor instanceof Person); //t
		
		System.out.println(pEleStu instanceof Student); //t
		System.out.println(pGWor instanceof Student); // f
		
		System.out.println(pEleStu instanceof Worker); //f
		System.out.println(pGWor instanceof Worker); //t
		
		System.out.println(pEleStu instanceof ElementStu); //t
		System.out.println(pGWor instanceof GoverWorker); //t
		
		System.out.println("********************************");
		
		Student sEleStu = new ElementStu();
		Worker wGoverWor = new GoverWorker();
		
		System.out.println(sEleStu instanceof Person); //t
		System.out.println(wGoverWor instanceof Person); //t
		
		System.out.println(sEleStu instanceof Student); //t
		System.out.println(wGoverWor instanceof Worker); //t
		
		System.out.println(sEleStu instanceof Student); //t
		System.out.println(wGoverWor instanceof Worker); //t
	}

}
