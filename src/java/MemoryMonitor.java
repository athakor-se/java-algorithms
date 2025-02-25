package java;

/**
 * @author athakor
 */
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

public class MemoryMonitor {

    private static final int MB = 1024 * 1024;

    public static void printCurrentMemoryUsage() {
        // Get the memory MXBean
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // Get heap memory usage
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();

        // Get non-heap memory usage
        MemoryUsage nonHeapUsage = memoryBean.getNonHeapMemoryUsage();

        System.out.println("\n=== Memory Usage Summary ===");
        System.out.println("\nHEAP MEMORY:");
        System.out.printf("Init: %d MB%n", heapUsage.getInit() / MB);
        System.out.printf("Used: %d MB%n", heapUsage.getUsed() / MB);
        System.out.printf("Committed: %d MB%n", heapUsage.getCommitted() / MB);
        System.out.printf("Max: %d MB%n", heapUsage.getMax() / MB);

        System.out.println("\nNON-HEAP MEMORY:");
        System.out.printf("Init: %d MB%n", nonHeapUsage.getInit() / MB);
        System.out.printf("Used: %d MB%n", nonHeapUsage.getUsed() / MB);
        System.out.printf("Committed: %d MB%n", nonHeapUsage.getCommitted() / MB);
        System.out.printf("Max: %d MB%n", nonHeapUsage.getMax() / MB);

        // Print details for each memory pool
        printMemoryPoolDetails();
    }

    public static void printMemoryPoolDetails() {
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();

        System.out.println("\nMEMORY POOL DETAILS:");
        for (MemoryPoolMXBean pool : memoryPoolMXBeans) {
            System.out.printf("\nPool: %s (%s)%n",
                    pool.getName(),
                    pool.getType());
            MemoryUsage usage = pool.getUsage();
            System.out.printf("Used: %d MB%n", usage.getUsed() / MB);
            System.out.printf("Committed: %d MB%n", usage.getCommitted() / MB);
            System.out.printf("Max: %d MB%n", usage.getMax() / MB);
        }
    }

    public static double getHeapUsagePercentage() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        return ((double) heapUsage.getUsed() / heapUsage.getMax()) * 100;
    }

    // Example usage with periodic monitoring
    public static void startPeriodicMonitoring(long intervalMs) {
        Thread monitorThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                printCurrentMemoryUsage();
                try {
                    Thread.sleep(intervalMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        monitorThread.setDaemon(true);
        monitorThread.start();
    }

    // Example main method showing usage
    public static void main(String[] args) {
        // Print current memory usage
        printCurrentMemoryUsage();

        // Start periodic monitoring (every 5 seconds)
        startPeriodicMonitoring(5000);
    }
}
