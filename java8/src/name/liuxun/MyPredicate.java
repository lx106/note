package name.liuxun;


@FunctionalInterface
public interface MyPredicate<Employee> {

	public boolean test(Employee e);
}
