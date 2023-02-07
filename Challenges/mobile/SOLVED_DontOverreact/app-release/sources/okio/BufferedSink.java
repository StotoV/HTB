package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    /* renamed from: emitCompleteSegments */
    BufferedSink mo217emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    OutputStream outputStream();

    /* renamed from: write */
    BufferedSink mo218write(ByteString byteString) throws IOException;

    BufferedSink write(Source source, long j) throws IOException;

    /* renamed from: write */
    BufferedSink mo219write(byte[] bArr) throws IOException;

    /* renamed from: write */
    BufferedSink mo220write(byte[] bArr, int i, int i2) throws IOException;

    long writeAll(Source source) throws IOException;

    /* renamed from: writeByte */
    BufferedSink mo221writeByte(int i) throws IOException;

    /* renamed from: writeDecimalLong */
    BufferedSink mo222writeDecimalLong(long j) throws IOException;

    /* renamed from: writeHexadecimalUnsignedLong */
    BufferedSink mo223writeHexadecimalUnsignedLong(long j) throws IOException;

    /* renamed from: writeInt */
    BufferedSink mo224writeInt(int i) throws IOException;

    /* renamed from: writeIntLe */
    BufferedSink mo225writeIntLe(int i) throws IOException;

    /* renamed from: writeLong */
    BufferedSink mo226writeLong(long j) throws IOException;

    /* renamed from: writeLongLe */
    BufferedSink mo227writeLongLe(long j) throws IOException;

    /* renamed from: writeShort */
    BufferedSink mo228writeShort(int i) throws IOException;

    /* renamed from: writeShortLe */
    BufferedSink mo229writeShortLe(int i) throws IOException;

    /* renamed from: writeString */
    BufferedSink mo230writeString(String str, int i, int i2, Charset charset) throws IOException;

    /* renamed from: writeString */
    BufferedSink mo231writeString(String str, Charset charset) throws IOException;

    /* renamed from: writeUtf8 */
    BufferedSink mo232writeUtf8(String str) throws IOException;

    /* renamed from: writeUtf8 */
    BufferedSink mo233writeUtf8(String str, int i, int i2) throws IOException;

    /* renamed from: writeUtf8CodePoint */
    BufferedSink mo234writeUtf8CodePoint(int i) throws IOException;
}
