package org.mtr.mod.packet;

import org.mtr.core.operation.RequestStop;
import org.mtr.core.serializer.JsonReader;
import org.mtr.core.serializer.SerializedDataBase;
import org.mtr.core.servlet.OperationProcessor;
import org.mtr.core.tool.Utilities;
import org.mtr.mapping.tool.PacketBufferReceiver;

import javax.annotation.Nonnull;

public final class PacketRequestStop extends PacketRequestResponseBase {
	
	public static PacketRequestStop create(long sidingId, long vehicleId) {
		return new PacketRequestStop(new RequestStop(sidingId, vehicleId));
	}

	public PacketRequestStop(PacketBufferReceiver packetBufferReceiver) {
		super(packetBufferReceiver);
	}

	public PacketRequestStop(RequestStop contentObject) {
		super(Utilities.getJsonObjectFromData(contentObject).toString());
	}

	private PacketRequestStop(String content) {
		super(content);
	}

	@Override
	protected PacketRequestResponseBase getInstance(String content) {
		return new PacketRequestStop(content);
	}

	@Override
	protected SerializedDataBase getDataInstance(JsonReader jsonReader) {
		return new RequestStop(jsonReader);
	}

	@Nonnull
	@Override
	protected String getKey() {
		return OperationProcessor.REQUEST_STOP;
	}

	@Override
	protected PacketRequestResponseBase.ResponseType responseType() {
		return PacketRequestResponseBase.ResponseType.NONE;
	}
}
