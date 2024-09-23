package CODING;

class Passenger {
    String name;
    Passenger next;

    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;

    public Flight() {
        this.head = null;
    }

    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Tidak ada penumpang untuk dihapus.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Penumpang " + name + " berhasil dihapus.");
            return;
        }

        Passenger current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Penumpang dengan nama " + name + " tidak ditemukan.");
        } else {
            current.next = current.next.next;
            System.out.println("Penumpang " + name + " berhasil dihapus.");
        }
    }

    public void displayPassengers() {
        if (head == null) {
            System.out.println("Tidak ada penumpang dalam daftar.");
            return;
        }

        Passenger current = head;
        System.out.println("Daftar Penumpang:");
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight();
        flight.addPassenger("OPUK");
        flight.addPassenger("ADLI");
        flight.addPassenger("ALAMAK");

        System.out.println("Daftar penumpang awal:");
        flight.displayPassengers();

        System.out.println("\nMenghapus penumpang");
        flight.removePassenger("OPUK");
        flight.displayPassengers();

        System.out.println("\nMenghapus penumpang");
        flight.removePassenger("EH HAAH LAH");
        flight.displayPassengers();
    }
}
