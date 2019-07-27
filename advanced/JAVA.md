
- [jdbc](#jdbc)
- [hibernate](#hibernate)
- [Programowanie funkcyjne](#Programowanie-funkcyjne)
- [Moduły](#Moduły)


# jdbc
``` java
    Connection connection = DriverManager.getConnection("org.h2.Driver", "", "");
    Statement statement = connection.createStatement();
    
    String insert = "INSERT INTO STUDENT VALUES(" + student.getId() + ",'" + student.getName() + "')";
    statement.execute(insert); 
    
    ResultSet resultSet = statement.executeQuery(select);
```    
# hibernate
``` java
    persistence.xml w META-INF, lub hibernate.cfg.xml

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistence");
    EntityManager entityManager = factory.createEntityManager();
```

## Encje:    

``` java
    @Entity(name = "someThing") - nazwa nie potrzebna
    @Table(name = "someThing") - zmiana domyślnej nazwy tabeli
    
    @Id    // to i to poniżej przed wartością - spring mapuje na pola, - przed geterem - mapuje przez getery i setery
    @GeneratedValue(strategy = GenerationType.AUTO) 
    
    @Transient - nie będzie w bazie
    @Embedded - dla wygody w innej klasie, będzie w tej samej tabeli
    @Column(name = "Opis") // zmiana nazwy kolumny, można tak też inne rzeczy
```
## Inne:
``` java    
    @PersistenceContext 
    private EntityManager entityManager;
    
    @Transactional - metoda jest bazodanową tranzakcją
    entityManager.merge(quest); // zaktualizuje quest  - jeśli quest ma id, lub utworzy jeśli nie ma, i zwrocata obiekt zaktualizowany
    entityManager.persist(aga); // persist nic nie zwraca
    entityManager.detach(employee); // odłącza employee od zarządzania przez entityManager, merge może go dołączyć
    
    @Embedded // dołącza pola innej klasy do naszej encji
    private Address address;
    @Embeddable // to jeszcze można dać przed taką klasą
    
   @NamedQueries({
       @NamedQuery(name="Student.getAll", query= "Select s From Student s"),
       @NamedQuery(name="Student.byName", query= "Select s From Student s where s.name = :name"),
   }) // coś takego można przed encją, potem takie odwołanie
    entityManager.createNamedQuery("Student.byName", Student.class).setParameter("name", "Ania").getResultList().forEach(System.out::println);
``` 
# Programowanie funkcyjne
- klasy niemodyfikowalne (fą final, bez seterów, klasy zawierające są też niemodyfikowalne)
- czyste funkcje (jak już cos musimy zmienić to zwracamy nowy obiekt)
- unikamy nulli (przez zwracanie Optional)

>Interfejsy funkcyjne - to takie, które posiadają tylko 1 metodę, można go oznaczyć **@FunctionalInterface** i można do nich użyć lambdy:
``` java           
        Movable m1 = new Movable() {
            @Override
            public int move(String direction) {
                return 11;
            }
        };
        Movable m2 = (String direction) -> {
            return 11;
        };
        Movable m3 = (String direction) -> 11; // jak jest 1 linijka to nie piszemy return
        Movable m4 =  direction -> 11; // jak jest 1 argument to nie trzeba podawać jego typu
```
>Predicate - takie interfejs, który zamienia jakiś obiekt na booleana
``` java
        Predicate<Student> isAnia = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getName().equals("Ania");
            }
        };
        Predicate<Student> isUnder30 = student ->  student.getAge() < 30;
        Predicate<Student> isAniaAndUnder30 = isAnia.and(isUnder30);
        Predicate<Student> isAniaORUnder30 = isAnia.or(isUnder30);
        Predicate<Student> isNotAnia = isAnia.negate();
```
>Consumer - bierze jakiś obiekt, wykonuje jakąś operację i nic nie zwraca
``` java
        Consumer<Student> printStudentName = new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student.getName());
            }
        };

        Consumer<Student> printStudentName = (student) ->  System.out.println(student.getName());
        //można je też łączyć
        printStudentName.andThen(printStudentNameToUppercase))
```
>Supplier - odwrotnie, nie bierze argumentów, coś zwraca
``` java
        Supplier<List<Student>> supplierPredefinedStudents = new Supplier<List<Student>>() {
            @Override
            public List<Student> get() {
                return createData();
            }
        };
        Supplier<List<Student>> supplierPredefinedStudents = () -> createData();
        Supplier<List<Student>> supplierPredefinedStudents = App::createData;
```
>Function - bierze 1 typ obiektu, modyfikuje go i zwraca inny typ obiektu
``` java
        Function<Student,String> getStudentName = new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        };

        Function<Student,String> getStudentName2 = student -> student.getName();
        Function<Student,String> getStudentName3 = Student::getName;
```
>BiFunction - bierze 2 typy i zwraca 3
``` java
        BiFunction<String, Student, Integer> bifunction = new BiFunction<String, Student, Integer>() {
            @Override
            public Integer apply(String s, Student student) {
                return null;
            }
        };
```
>BinaryOperator - bierze 2 obiekty i zwraca 1 
``` java
        BinaryOperator<Student> binaryOperator = new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {
                return null;
            }
        };
```
>prymitywne interfejsy - żeby nie operować na klasach
``` java
        IntPredicate intPredicate = new IntPredicate() {  //są też inne, a odwrotnie działające mają przedrostek "To"
            @Override
            public boolean test(int value) {
                return false;
            }
        };
```
>Optional - opakowuje inny obiekt, które być, albo może go nie być
``` java        
        Tworzymy:
         
         Optional.ofNullable(zmienna); // tak można stowrzyć
         Optional.of(zmienna) // to gdy jesteśmy pewni, że wartość nie jest nullem
         Optional.empty() // pusty
         Optional.get() - pobiera wartość, zwróci wyjątek, jesli bedzie to null
         
        Potem:
        index.ifPresent(new Consumer<Index>() {
            @Override
            public void accept(Index index) {
                System.out.println(index.getName());
            }
        });
        
        Index aa = index.orElse(new Index("aa")); // zwraca index, a jeśli nie ma to nowy index
        Index aa2 = index.orElseGet(new Supplier<Index>() { // zwraca index, a jeśli go nie ma to zwraca suppliera
            @Override
            public Index get() {
                return null;
            }
        });
        index.filter(new Predicate<Index>() {
            @Override
            public boolean test(Index idx) {
                return idx.getName().equals("1234");
            }
        });

        index.filter(idx -> idx.getName().equals("1234")).ifPresent(new Consumer<Index>() {
            @Override
            public void accept(Index index) {
                System.out.println("Znalazłem");
            }
        });
        index.map(i -> i.getName()).filter(iName -> iName.equals("111")).ifPresent(indexNr -> System.out.println(indexNr));
```
## Operacje:
>Stream - Klasa, albo można też zrobić na kolekcjach, jednokrotnego użytku
``` java
        students.stream().filter(isAnia).map(getStudentName).forEach(print);
        // z kolekcji wybieramy te które spełniają filter, następnie 
        // mapujemy wybierając tylko imię i wyświetlamy imię
        TWORZENIE:
        Stream.of("A","B","C"); // wymienione
        students.stream(); // z kolekcji
        Stream.generate(() -> Math.random()).limit(10).forEach((v) -> System.out.println(v));
        Stream.generate(Math::random).limit(10).forEach(System.out::println); //losowy
        Stream.iterate(0, i->i+2).limit(20).forEach(System.out::println); // 20 liczb parzystych
        Są też streemy pymitywów, np InsStreem.rangeClosed(5,100).filter(i->i%2==0).forEach(System.out::println);
```
>filter - odfiltrowuje dane na streamach, przyjmuje predykat (zwracający booleanna), przepuszcza dane go spełniające
``` java
        Stream<Student> stream = createDataStream();
        stream
                .filter(student -> student.getAge() > 25)
                .filter((student) -> student.getName().equals("Ania"))
                .map(Student::getName)
                .forEach(print);
```
>map - przyjmuje funkcję (coś co na podstawie jednego obiektu zwraca inny) i mapuje jeden typ obiektu w drugi
``` java
        stream
                .map(student -> student.getIndex())
                .filter(optionalIndex -> optionalIndex.isPresent())
                .map(optionalInddex -> optionalInddex.get())
                .map(index -> index.getName())
                .forEach(System.out::println);
```
Są też mapy do prymitywów:
``` java
                createDataStream().map(Student::getAge).mapToInt(new ToIntFunction<Integer>() {
                    @Override
                    public int applyAsInt(Integer value) {
                        return value + 1;
                    }
                }).forEach(System.out::println);
```                
>forEach - przyjmuje consumera (coś co coś przyjmuje i nic nie zwraca)

>findFirst() - zwróci pierwszy obiekt który dotrze do tego momentu w strumieniu

>anyMatch(Predicate<T>) - przyjmuje predykat i zwraca boolana czy jakiś spełnia ten warunek

>allMatch(Predicate<T>) - j.w. tylko sprawdza czy wszystkie obiekty ze strumienia spełniają warunek

>noneMatch(Predicate<T>) - j.w. tylko sprawdza czy wszystkie obiekty ze strumienia nie spełniają warunku
``` java
        Boolean atLeastOneAnia = createDataStream()
                .anyMatch(student -> student.getName().equals("Ania"));
        Boolean allAreAnia = createDataStream()
                .allMatch(student -> student.getName().equals("Ania"));
        Boolean thereIsNotAnyAnia = createDataStream()
                .noneMatch(student -> student.getName().equals("Ania"));
```                
>reduce - przyjmuje wartość początkową i binary operator (przyjmujący 2 wartości i zwracający jedną z nich) zwraca jeden łączny wynik Binaryoeratora dla wszystkich elementów
    
``` java

        Double reduce = Stream.generate(Math::random).limit(10)
        //  .reduce(0.0, Double::sum) // to samo co
            .reduce(0.0, new BinaryOperator<Double>() {
            @Override
            public Double apply(Double aDouble, Double aDouble2) {
                return aDouble + aDouble2;
            }
        });
        
        createDataStream().map(student -> student.getAge())
    //          .reduce( (a1, a2) -> a1 > a2 ? a1 : a2) // to samo co
                .reduce(Integer::max)
                .ifPresent(System.out::println);
```
>collect - zbiera dane i zwraca listę, mapę albo coś innego
``` java
        String agesString = createDataStream().map(student -> student.getAge()).map(age -> age.toString()).collect(Collectors.joining(", "));
        System.out.println(agesString);

        Map<Integer, List<Student>> studentsByAgeMap = createDataStream().collect(groupingBy(Student::getAge));
        studentsByAgeMap.forEach(new BiConsumer<Integer, List<Student>>() {
            @Override
            public void accept(Integer integer, List<Student> students) {
                System.out.println(integer.toString() + ":");
                students.stream().map(Student::getName).forEach(System.out::println);
            }
        });
    }
```
>limit(3) - ile elementów przepuścić 

>skip(3) - ile początkowych elementów pominąć

>distinct() - przepuszcza tylko unikalne, bazuje na metodzie equals

>sorted() - bez argumentu - sortuje wg. naturalnego porządku korzysta z metody compareTo

>sorted(Comparator<T>) - można też z własnym comparatorem

>count() - ilość elementów w strumieniu

# Moduły
W każdym module w src trzeba utworzyć module-info.java:
``` java
module pl.clockworkjava.MainModule {
    requires java.logging;  // co używany
    requires pl.clockworkjava.AccountingModule; // jakieś inne nasze moduły
    requires pl.clockworkjava.SupplyModule;
} 

module pl.clockworkjava.AccountingModule {
    requires java.logging;
    exports pl.clockworkjava.accounting; // to trzeba napisać, żeby wystawić na zewnątrz publiczne metody klass, osobno dla każdej package
    // zawsze trzeba dodawać pełną paczke (nie wystarczy rodzic)
}
```
Jeśli używamy serwisu z innego modułu
``` java
module pl.clockworkjava.AccountingModule {
    requires pl.clockworkjava.PayrollService; // tu jest sam interfejs serwisu
    requires pl.clockworkjava.PolishPayroll; // tu jedna z implementacji
    exports pl.clockworkjava.accounting; // to że jest paczka accounting tego modułu jest widoczna na zewnątrz accounting

    uses pl.clockworkjava.payroll.PayrollService; // to że używa tego serwisu
}

Potem tak w kodzie mozna dostać się do niego dostać:
         ServiceLoader<PayrollService> services = ServiceLoader.load(PayrollService.class);
         services.findFirst().ifPresent(PayrollService::getCurrency);

// a to implementacja takiego serwisu:
module pl.clockworkjava.PolishPayroll {
    requires pl.clockworkjava.PayrollService;
    provides pl.clockworkjava.payroll.PayrollService with pl.clockworkjava.polishpayroll.PayrollServiceImpl;
    //ten moduł dostarcza implementacji do tego serwisu
}

```
Można tez lepiej, czyli w interfejsie serwisu dodajemy statyczną metodę
``` java
    static PayrollService getInstance(){
        ServiceLoader<PayrollService> services = ServiceLoader.load(PayrollService.class);
        Optional<PayrollService> first = services.findFirst();
        return first.orElseThrow(() -> new RuntimeException("Missing PayrollService implementation"));
    }
    I w module-info oznaczamy że sam siebie używa
    uses pl.clockworkjava.payroll.PayrollService; 
```
