package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Sink sink;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSink(Sink sink) {
        Objects.requireNonNull(sink, "sink == null");
        this.sink = sink;
    }

    @Override // okio.BufferedSink
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.write(buffer, j);
        mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: write */
    public BufferedSink mo218write(ByteString byteString) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo218write(byteString);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeUtf8 */
    public BufferedSink mo232writeUtf8(String str) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo232writeUtf8(str);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeUtf8 */
    public BufferedSink mo233writeUtf8(String str, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo233writeUtf8(str, i, i2);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeUtf8CodePoint */
    public BufferedSink mo234writeUtf8CodePoint(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo234writeUtf8CodePoint(i);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeString */
    public BufferedSink mo231writeString(String str, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo231writeString(str, charset);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeString */
    public BufferedSink mo230writeString(String str, int i, int i2, Charset charset) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo230writeString(str, i, i2, charset);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: write */
    public BufferedSink mo219write(byte[] bArr) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo219write(bArr);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: write */
    public BufferedSink mo220write(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo220write(bArr, i, i2);
        return mo217emitCompleteSegments();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int write = this.buffer.write(byteBuffer);
        mo217emitCompleteSegments();
        return write;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this.buffer, 8192L);
                if (read == -1) {
                    return j;
                }
                j += read;
                mo217emitCompleteSegments();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this.buffer, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            mo217emitCompleteSegments();
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: writeByte */
    public BufferedSink mo221writeByte(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo221writeByte(i);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeShort */
    public BufferedSink mo228writeShort(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo228writeShort(i);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeShortLe */
    public BufferedSink mo229writeShortLe(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo229writeShortLe(i);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeInt */
    public BufferedSink mo224writeInt(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo224writeInt(i);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeIntLe */
    public BufferedSink mo225writeIntLe(int i) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo225writeIntLe(i);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeLong */
    public BufferedSink mo226writeLong(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo226writeLong(j);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeLongLe */
    public BufferedSink mo227writeLongLe(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo227writeLongLe(j);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeDecimalLong */
    public BufferedSink mo222writeDecimalLong(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo222writeDecimalLong(j);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: writeHexadecimalUnsignedLong */
    public BufferedSink mo223writeHexadecimalUnsignedLong(long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.buffer.mo223writeHexadecimalUnsignedLong(j);
        return mo217emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    /* renamed from: emitCompleteSegments */
    public BufferedSink mo217emitCompleteSegments() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.buffer, completeSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.RealBufferedSink.1
            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                if (RealBufferedSink.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink.this.buffer.mo221writeByte((int) ((byte) i));
                RealBufferedSink.this.mo217emitCompleteSegments();
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (RealBufferedSink.this.closed) {
                    throw new IOException("closed");
                }
                RealBufferedSink.this.buffer.mo220write(bArr, i, i2);
                RealBufferedSink.this.mo217emitCompleteSegments();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                if (!RealBufferedSink.this.closed) {
                    RealBufferedSink.this.flush();
                }
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                RealBufferedSink.this.close();
            }

            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.buffer.size > 0) {
            Sink sink = this.sink;
            Buffer buffer = this.buffer;
            sink.write(buffer, buffer.size);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (this.buffer.size > 0) {
                Sink sink = this.sink;
                Buffer buffer = this.buffer;
                sink.write(buffer, buffer.size);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th == null) {
            return;
        }
        Util.sneakyRethrow(th);
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ")";
    }
}
