import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class TestRouteCalculator extends TestCase {

    ArrayList<Station> route1;
    ArrayList<Station> route2;
    ArrayList<Station> route3;
    StationIndex varStationIndex = new StationIndex();
    RouteCalculator varRouteCalculator = new RouteCalculator(varStationIndex);

    @Override
    protected void setUp() throws Exception {
//СХЕМА МЕТРО
        //Создание линий
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        varStationIndex.addLine(line1);
        varStationIndex.addLine(line2);
        varStationIndex.addLine(line3);

        //Создание станций
        varStationIndex.addStation(new Station("Ботаническая", line1));
        varStationIndex.addStation(new Station("Чкаловская", line1)); // пересекается с КАЛИНОВСКОЙ
        varStationIndex.addStation(new Station("Геологическая", line1));
        varStationIndex.addStation(new Station("Площадь 1905 года", line1)); // пересекается с ВОСТОЧНОЙ
        varStationIndex.addStation(new Station("Динамо", line1));
        varStationIndex.addStation(new Station("Уральская", line1));
        varStationIndex.addStation(new Station("Машиностроителей", line1));
        varStationIndex.addStation(new Station("Уралмаш", line1));
        varStationIndex.addStation(new Station("Проспект Космонавтов", line1));
        line1.addStation(varStationIndex.getStation("Ботаническая"));
        line1.addStation(varStationIndex.getStation("Чкаловская"));
        line1.addStation(varStationIndex.getStation("Геологическая"));
        line1.addStation(varStationIndex.getStation("Площадь 1905 года"));
        line1.addStation(varStationIndex.getStation("Динамо"));
        line1.addStation(varStationIndex.getStation("Уральская"));
        line1.addStation(varStationIndex.getStation("Машиностроителей"));
        line1.addStation(varStationIndex.getStation("Уралмаш"));
        line1.addStation(varStationIndex.getStation("Проспект Космонавтов"));

        varStationIndex.addStation(new Station("Волгоградская", line2));
        varStationIndex.addStation(new Station("Посадская", line2));
        varStationIndex.addStation(new Station("Калиновская", line2)); // пересекается с ЧКАЛОВСКОЙ
        varStationIndex.addStation(new Station("Театральная", line2)); // пересекается с ТЕХНИЧЕСКИМ УНИВЕРСИТЕТОМ
        varStationIndex.addStation(new Station("Гагаринская", line2));
        varStationIndex.addStation(new Station("Комсомольская", line2));
        varStationIndex.addStation(new Station("Шарташская", line2));
        line2.addStation(varStationIndex.getStation("Волгоградская"));
        line2.addStation(varStationIndex.getStation("Посадская"));
        line2.addStation(varStationIndex.getStation("Калиновская"));
        line2.addStation(varStationIndex.getStation("Театральная"));
        line2.addStation(varStationIndex.getStation("Гагаринская"));
        line2.addStation(varStationIndex.getStation("Комсомольская"));
        line2.addStation(varStationIndex.getStation("Шарташская"));

        varStationIndex.addStation(new Station("Верх - Исетская", line3));
        varStationIndex.addStation(new Station("Татищевская", line3));
        varStationIndex.addStation(new Station("Уральских Коммунаров", line3));
        varStationIndex.addStation(new Station("Восточная", line3)); // пересекается с ПЛОЩАДЬЮ 1905 ГОДА
        varStationIndex.addStation(new Station("Технический университет", line3)); // пересекается с ТЕАТРАЛЬНОЙ
        varStationIndex.addStation(new Station("Студенческая", line3));
        varStationIndex.addStation(new Station("Каменные палатки", line3));
        line3.addStation(varStationIndex.getStation("Верх - Исетская"));
        line3.addStation(varStationIndex.getStation("Татищевская"));
        line3.addStation(varStationIndex.getStation("Уральских Коммунаров"));
        line3.addStation(varStationIndex.getStation("Восточная"));
        line3.addStation(varStationIndex.getStation("Технический университет"));
        line3.addStation(varStationIndex.getStation("Студенческая"));
        line3.addStation(varStationIndex.getStation("Каменные палатки"));


//Пометка станций с пересадкой
        List<Station> connectedStations = new ArrayList<>();
        connectedStations.add(varStationIndex.getStation("Чкаловская"));
        connectedStations.add(varStationIndex.getStation("Калиновская"));
        varStationIndex.addConnection(connectedStations);
        connectedStations.clear();
        connectedStations.add(varStationIndex.getStation("Площадь 1905 года"));
        connectedStations.add(varStationIndex.getStation("Восточная"));
        varStationIndex.addConnection(connectedStations);
        connectedStations.clear();
        connectedStations.add(varStationIndex.getStation("Театральная"));
        connectedStations.add(varStationIndex.getStation("Технический Университет"));
        varStationIndex.addConnection(connectedStations);
        connectedStations.clear();


        //Создание первого маршрута
        route1 = new ArrayList<>();
        route1.add(varStationIndex.getStation("Ботаническая"));
        route1.add(varStationIndex.getStation("Чкаловская"));
        route1.add(varStationIndex.getStation("Геологическая"));
        route1.add(varStationIndex.getStation("Площадь 1905 года"));
        route1.add(varStationIndex.getStation("Динамо"));
        route1.add(varStationIndex.getStation("Уральская"));
        route1.add(varStationIndex.getStation("Машиностроителей"));
        route1.add(varStationIndex.getStation("Уралмаш"));
        route1.add(varStationIndex.getStation("Проспект Космонавтов"));

//МАРШРУТЫ
        //Создание второго маршрута
        route2 = new ArrayList<>();
        route2.add(varStationIndex.getStation("Волгоградская"));
        route2.add(varStationIndex.getStation("Посадская"));
        route2.add(varStationIndex.getStation("Калиновская"));
        route2.add(varStationIndex.getStation("Театральная"));
        route2.add(varStationIndex.getStation("Технический университет"));
        route2.add(varStationIndex.getStation("Восточная"));
        route2.add(varStationIndex.getStation("Уральских Коммунаров"));
        route2.add(varStationIndex.getStation("Татищевская"));
        route2.add(varStationIndex.getStation("Верх - Исетская"));

        //Создание третьего маршрута
        route3 = new ArrayList<>();
        route3.add(varStationIndex.getStation("Проспект Космонавтов"));
        route3.add(varStationIndex.getStation("Уралмаш"));
        route3.add(varStationIndex.getStation("Машиностроителей"));
        route3.add(varStationIndex.getStation("Уральская"));
        route3.add(varStationIndex.getStation("Динамо"));
        route3.add(varStationIndex.getStation("Площадь 1905 года"));
        route3.add(varStationIndex.getStation("Восточная"));
        route3.add(varStationIndex.getStation("Технический университет"));
        route3.add(varStationIndex.getStation("Театральная"));
        route3.add(varStationIndex.getStation("Гагаринская"));
        route3.add(varStationIndex.getStation("Комсомольская"));
        route3.add(varStationIndex.getStation("Шарташская"));
    }

    public void testGetRouteOnLine() {
        List<Station> actual = varRouteCalculator.getShortestRoute(varStationIndex.getStation("Ботаническая"), varStationIndex.getStation("Проспект Космонавтов"));
        List<Station> expected = route1;
        assertEquals("Маршрут без пересадок не верен", expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> actual = varRouteCalculator.getShortestRoute(varStationIndex.getStation("Волгоградская"), varStationIndex.getStation("Верх - Исетская"));
        List<Station> expected = route2;
        assertEquals("Маршрут с одной пересадкой не верен",expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = varRouteCalculator.getShortestRoute(varStationIndex.getStation("Проспект Космонавтов"), varStationIndex.getStation("Шарташская"));
        List<Station> expected = route3;
        assertEquals("Маршрут с двумя пересадками пересадок не верен",expected, actual);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route3);
        double expected = 29.5;
        assertEquals("Время расчета маршрута не верно",expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
