# Fix possible "host contamination" error (package files owned by builder and not root)

do_install_append() {
	chown -R root:root ${D}
}

