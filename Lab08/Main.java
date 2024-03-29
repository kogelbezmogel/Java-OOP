import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {

    private static final EmployeeService employeeService = new EmployeeService();

    public static void main(String[] args) {
        System.out.println("--- For Each ---\n");
        List<Employee> employeeList = employeeService.getEmployeeList();
        employeeList.stream().forEach(e -> System.out.println(e));
        employeeList.stream().forEach(e -> e.incrementSalary(200.));
        System.out.println();
        employeeList.forEach(System.out::println);

        System.out.println("\n--- Map ---\n");
        employeeList = new ArrayList<>();
        List<Long> idList = List.of(1L, 2L, 3L);

        // map id list to employee list
        employeeList =  idList.stream().map(  id ->  employeeService.findById(id) ).collect( Collectors.toList() );

        employeeList.forEach(System.out::println);

        System.out.println("\n--- Filter ---\n");
        employeeList = new ArrayList<>();
        idList = List.of(1L, 2L, 3L, 4L);

        // map id list to employee list
        employeeList =  idList.stream().map(  id ->  employeeService.findById(id) ).collect( Collectors.toList() );
        // filter to remove all nulls
        employeeList = employeeList.stream().filter( x -> x != null ).collect( Collectors.toList() );
        // filter to get only those with salary greater than 200000
        employeeList = employeeList.stream().filter( x -> x.getSalary() > 200000 ).collect( Collectors.toList() );

        employeeList.forEach(System.out::println);

        System.out.println("\n--- Find First ---\n");
        employeeList = employeeService.getEmployeeList();
        Employee employee = null;

        // filter employee list to get only those with salary greater than 150000
        employeeList = employeeList.stream().filter( x -> x.getSalary() > 150000 ).collect( Collectors.toList() );
        // get first result
        // or else null
        employee = employeeList.stream().findFirst().orElse(null);

        System.out.println(employee);

        System.out.println("\n--- Flat Map ---\n");
        employeeList = new ArrayList<>();
        List<List<Long>> idNestedList = List.of(
                List.of(1L),
                List.of(2L),
                List.of(3L));

        // flat map list of lists to get single list
        idList = idNestedList.stream().flatMap( Collection::stream ).collect( Collectors.toList() );
        // map id to employee
        employeeList =  idList.stream().map(  id ->  employeeService.findById(id) ).collect( Collectors.toList() );

        employeeList.forEach(System.out::println);

        System.out.println("\n--- Peek ---\n");
        employeeList = employeeService.getEmployeeList();

        // increment salary by 300
        employeeList.stream().peek( x -> x.incrementSalary(300.) ).filter(x -> x.getSalary() >= 300500 ).forEach(x -> System.out.println(x) );
        // filter to get only those with salary greater than 300500
        // print employee

        System.out.println("\n--- Sorted ---\n");
        employeeList = employeeService.getEmployeeList();

        // sort by employee name
        employeeList = employeeList.stream().sorted( (x,y) -> x.getName().compareTo(y.getName()) ).collect(Collectors.toList());

        employeeList.forEach(System.out::println);

        System.out.println("\n--- Min / Max ---\n");
        employeeList = employeeService.getEmployeeList();

        // get min salary
        employee = employeeList.stream().min( (x,y) -> (int) (x.getSalary() - y.getSalary()) ).orElse(null);

        System.out.println(employee);

        System.out.println("\n--- All / Any / None Match ---\n");
        List<Integer> numbers = List.of(2, 4, 5, 6, 8);
        boolean allEven = false, oneEven = false, noneMultipleOfThree = false;

        // check if all numbers are even
        allEven = numbers.stream().allMatch( x -> x % 2 == 1 );
        // check if any number is even
        oneEven = numbers.stream().anyMatch( x -> x % 2 == 1 );
        // check if none of the numbers are mulitple of three
        noneMultipleOfThree = numbers.stream().allMatch( x -> x % 3 != 0 );

        System.out.println(
                "All even? " + allEven + ", one even? " + oneEven + " none multiple of three? " + noneMultipleOfThree);

        System.out.println("\n--- Map to double ---\n");
        employeeList = employeeService.getEmployeeList();
        Double salaryAverage = 0.;

        // map to double
        salaryAverage =  employeeList.stream().mapToDouble( x -> x.getSalary() ).average().orElse(0);
        // get average value
        // or else 0

        System.out.println(salaryAverage);

        System.out.println("\n--- Reduce ---\n");
        numbers = List.of(2, 5, 10);
        Integer result = 0;

        // reduce list to get result equal to 2 * 5 * 10
        result = numbers.stream().reduce( 1, (res,x) -> res *= x );
        System.out.println(result);
    }
}
