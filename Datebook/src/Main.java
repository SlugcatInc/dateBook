import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecordModel model = new RecordModelImpl();
        RecordView view = new RecordViewImpl();
        RecordPresenter presenter = new RecordPresenterImpl(model, view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить запись");
            System.out.println("2. Показать все записи");
            System.out.println("3. Найти записи по дате");
            System.out.println("4. Найти записи по неделе");
            System.out.println("5. Сортировать записи");
            System.out.println("6. Сохранить записи в файл");
            System.out.println("7. Загрузить записи из файла");
            System.out.println("8. Выход");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите дату, время и описание записи:");
                    String date = scanner.next();
                    String time = scanner.next();
                    String description = scanner.next();
                    presenter.addRecord(date, time, description);
                    break;
                case 2:
                    presenter.showRecords();
                    break;
                case 3:
                    System.out.println("Введите дату для поиска:");
                    String searchDate = scanner.next();
                    presenter.searchRecordsByDate(searchDate);
                    break;
                case 4:
                    System.out.println("Введите неделю для поиска:");
                    String searchWeek = scanner.next();
                    presenter.searchRecordsByWeek(searchWeek);
                    break;
                case 5:
                    presenter.sortRecords();
                    presenter.showRecords();
                    break;
                case 6:
                    System.out.println("Введите имя файла для сохранения:");
                    String filename = scanner.next();
                    presenter.saveRecordsToFile(filename);
                    break;
                case 7:
                    System.out.println("Введите имя файла для загрузки:");
                    filename = scanner.next();
                    presenter.loadRecordsFromFile(filename);
                    break;
                case 8:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}