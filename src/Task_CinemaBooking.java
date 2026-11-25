import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Task_CinemaBooking {

    // A seat in the cinema hall, for example B5 = row B, seat number 5.
    static class Seat {
        final char row;     // 'A' to 'E'
        final int number;   // 1 to 6

        Seat(char row, int number) {
            this.row = row;
            this.number = number;
        }

        @Override
        public String toString() {
            return "" + row + number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (!(o instanceof Seat)) {
                return false;
            }

            Seat seat = (Seat) o;
            return row == seat.row && number == seat.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, number);
        }
    }

    public static void main(String[] args) {

        // Key = Seat, Value = name of the customer who booked it
        HashMap<Seat, String> bookings = new HashMap<>();
        HashSet<Seat> broken = new HashSet<>();

        // Part A: book these seats using put()
        // A1 -> Ali, A2 -> Sara, B5 -> Omar, C3 -> Mona
        bookings.put(new Seat('A', 1), "Ali");
        bookings.put(new Seat('A', 2), "Sara");
        bookings.put(new Seat('B', 5), "Omar");
        bookings.put(new Seat('C', 3), "Mona");

        System.out.println("Bookings:           " + bookings);

        // Part B: who booked seat C3? Use get().
        System.out.println("Who booked C3:      " +
                bookings.get(new Seat('C', 3)));

        // Part C: are seats A2 and E6 taken? Use containsKey().
        System.out.println("Is A2 taken:        " +
                bookings.containsKey(new Seat('A', 2)));
        System.out.println("Is E6 taken:        " +
                bookings.containsKey(new Seat('E', 6)));

        // Part D: Youssef wants seat B5. Use putIfAbsent().
        String existingCustomer =
                bookings.putIfAbsent(new Seat('B', 5), "Youssef");

        if (existingCustomer == null) {
            System.out.println("Youssef -> B5:      booked");
        } else {
            System.out.println("Youssef -> B5:      refused, taken by " +
                    existingCustomer);
        }

        // Part E: Ali moves from seat A1 to seat D2.
        bookings.remove(new Seat('A', 1));
        bookings.put(new Seat('D', 2), "Ali");

        System.out.println("After Ali moved:    " + bookings);

        // Part F: seats E1 and E2 are broken. Use contains().
        broken.add(new Seat('E', 1));
        broken.add(new Seat('E', 2));

        Seat requestedSeat = new Seat('E', 1);

        if (broken.contains(requestedSeat)) {
            System.out.println("Hana -> E1:         refused, seat is broken");
        } else {
            bookings.put(requestedSeat, "Hana");
            System.out.println("Hana -> E1:         booked");
        }

        // Part G: how many seats are booked? Use size().
        System.out.println("Seats booked:       " + bookings.size());

        // GIVEN - prints the seating chart
        System.out.println();
        printChart(bookings, broken);
    }

    // GIVEN - do not change. Prints the hall: X = booked, # = broken, . = free
    static void printChart(HashMap<Seat, String> bookings,
                           HashSet<Seat> broken) {
        System.out.println("     1  2  3  4  5  6");
        for (char row = 'A'; row <= 'E'; row++) {
            System.out.print(row + "  ");
            for (int number = 1; number <= 6; number++) {
                Seat seat = new Seat(row, number);
                if (bookings.containsKey(seat)) {
                    System.out.print("  X");
                } else if (broken.contains(seat)) {
                    System.out.print("  #");
                } else {
                    System.out.print("  .");
                }
            }
            System.out.println();
        }
    }
}
