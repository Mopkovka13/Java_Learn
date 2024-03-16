package org.example.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {
    // Можно взять все, кроме одного (* *(*) && !один определенный)



/*    @Pointcut("execution(* org.example.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary(){}

    @Pointcut("execution(* org.example.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()") // можно комбинировать
    private void allGetAndReturnMethodsFromUniLibrary(){}

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoginAdvice() {
        System.out.println("beforeGetLoginAdvice: written log#1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoginAdvice() {
        System.out.println("beforeReturnLoginAdvice: written log#2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoginAdvice() {
        System.out.println("beforeGetAndReturnLoginAdvice: written log#3");
    }*/












    // Если сделать public, то можно использовать в других классах
    //@Pointcut("execution(* get*())")
    //private void allGetMethods(){}


    // Pointcut - где должен быть применён Advice
    // Advice - метод совет в классе Aspect
    // Before - до метода с основной логикой
    // AfterReturning - после корректного выполнения метода с основной логикой
    // AfterThrowing - в случае ошибки
    // After/After finally - выполняется после окончания метода с основной логикой
    // Around - До и после метода

    //@Before("allGetMethods()")
    //@Before("execution(* *(..))") // любое количество параметров
    //@Before("execution(* *(*))") // любой метод с любым одним параметром
    //@Before("execution(* getBook(*))") // с любым одним параметром
    //@Before("execution(* getBook(String))") // с параметром
    //@Before("execution(public void get*())") // любое название метода, начинающееся на get (по шаблону)
    //@Before("execution(public void org.example.UniLibrary.getBook())") // Явно указываем для какого именно класса отрабатывать
    //@Before("execution(public void getBook())")
    /*public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }*/

    /*@Before("allGetMethods()") // без параметро и мод. доступа, начинается название на get
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: проверка прав доступа на получения журнала/книги");
    }*/

    //@Before("execution(* returnBook())") // с любым мод. доступа и типом возвращ. значения
    //@Before("execution(public * returnBook())") // с любым типом возвращаемого значения
    //@Before("execution(public void returnBook())")
    /*public void beforeReturnBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка вернуть книгу");
    }*/


}
