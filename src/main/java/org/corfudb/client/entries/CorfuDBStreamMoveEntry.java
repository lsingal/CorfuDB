package org.corfudb.client.entries;

import org.corfudb.client.view.WriteOnceAddressSpace;
import org.corfudb.client.CorfuDBClient;
import org.corfudb.client.Timestamp;

import java.util.Map;
import java.util.ArrayList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.io.Serializable;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectInput;
import java.io.IOException;

public class CorfuDBStreamMoveEntry extends CorfuDBStreamEntry
{
    private static final long serialVersionUID = 0L;
    public final UUID destinationLog;
    public final UUID destinationStream;
    public final long destinationPos;
    public long destinationEpoch;
    public final int duration;

    public CorfuDBStreamMoveEntry(UUID streamID, UUID destinationLog, UUID destinationStream, long destinationPos, int duration, long epoch)
    {
        super(streamID, epoch);
        this.destinationStream = destinationStream;
        this.destinationLog = destinationLog;
        this.destinationPos = destinationPos;
        this.duration = duration;
    }

    public CorfuDBStreamMoveEntry(UUID streamID, UUID destinationLog, UUID destinationStream, long destinationPos, int duration, long epoch, long destinationEpoch)
    {
        this(streamID, destinationLog, destinationStream, destinationPos, duration, epoch);
        this.destinationEpoch = destinationEpoch;
    }

    public CorfuDBStreamMoveEntry(UUID streamID, UUID destinationLog, UUID destinationStream, long destinationPos, int duration, long epoch, long destinationEpoch, byte[] payload)
    {
        this(streamID, destinationLog, destinationStream, destinationPos, duration, epoch, destinationEpoch);
        this.payload = payload;
    }

    public CorfuDBStreamMoveEntry(Map<UUID, Long> epochMap, UUID destinationLog, UUID destinationStream, long destinationPos, int duration, long destinationEpoch, byte[] payload)
    {
        super(epochMap);
        this.destinationStream = destinationStream;
        this.destinationEpoch = destinationEpoch;
        this.destinationLog = destinationLog;
        this.destinationPos = destinationPos;
        this.duration = duration;
        this.payload = payload;
    }

    public CorfuDBStreamMoveEntry(Map<UUID, Long> epochMap, UUID destinationLog, UUID destinationStream, long destinationPos, int duration, long destinationEpoch, Serializable payload)
    throws IOException
    {
        super(epochMap, payload);
        this.destinationStream = destinationStream;
        this.destinationEpoch = destinationEpoch;
        this.destinationLog = destinationLog;
        this.destinationPos = destinationPos;
        this.duration = duration;
    }



}
