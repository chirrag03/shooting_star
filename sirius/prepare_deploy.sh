#!/usr/bin/env bash
#/bin/sh
echo -e "\nCopying old Snapshot to previous"
cp current/sirius-1.0-SNAPSHOT.zip previous/
echo -e "\nGenerating new snapshot....."
activator clean dist
rm -rf current/*
echo -e "\nCopying new Snapshot to current"
cp target/universal/sirius-1.0-SNAPSHOT.zip current/
echo -e "\nReady For Deployment......"
