package co.project.bench;

interface IBenchmark {
 void initialize(Object...params);
 void run();
 void clean();
 void cancel();
}
