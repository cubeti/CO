package co.project.logger;
interface ILogger {

	void write(long n);
	void write (String s);
	void write(Object... values);
}
