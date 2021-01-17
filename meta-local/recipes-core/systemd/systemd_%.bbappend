
do_install_append () {
	# Get rid of some crap
	rm -f ${D}/${systemd_unitdir}/network/*
}

