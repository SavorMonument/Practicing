package mine;

import java.nio.ByteBuffer;

public class ByteBufferVsByteOperations
{

	public static void main(String[] args)
	{
		final int times = 1_000_000;
		DeltaTime dt = new DeltaTime();

		dt.reset();
		convertBitwiseOperation(times);
		System.out.println("Bitwise: " + dt.getElapsedTimeMillis() + " millis");

		dt.reset();
		convertByteBuffer(times);
		System.out.println("ByteBuffer: " + dt.getElapsedTimeMillis() + " millis");

		dt.reset();
		convertByteBuffer(times);
		System.out.println("ByteBuffer: " + dt.getElapsedTimeMillis() + " millis");

		dt.reset();
		convertBitwiseOperation(times);
		System.out.println("Bitwise: " + dt.getElapsedTimeMillis() + " millis");
	}

	private static int convertByteBuffer(int numberOfTimes)
	{
		ByteBuffer byteBuffer = ByteBuffer.allocate(4);
		byte[] bytes = new byte[4];
		int number = 0;

		for (int i = 0; i < numberOfTimes; i++)
		{
			byteBuffer.position(0);
			byteBuffer.putInt(i);
			bytes = byteBuffer.array();
			number = ByteBuffer.wrap(bytes).getInt();
		}

		return number;
	}

	private static int convertBitwiseOperation(int numberOfTimes)
	{
		byte[] buffer = new byte[4];
		int number = 0;

		for (int i = 0; i < numberOfTimes; i++)
		{
			buffer[0] = (byte) (i >> 24);
			buffer[1] = (byte) (i >> 16);
			buffer[2] = (byte) (i >> 8);
			buffer[3] = (byte) (i >> 0);

			number = 0;
			number |= ((buffer[0] & 0xFF) << 24) | ((buffer[1] & 0xFF) << 16) | ((buffer[2] & 0xFF) << 8) | ((buffer[3] & 0xFF) << 0);
		}

		return number;
	}

}
