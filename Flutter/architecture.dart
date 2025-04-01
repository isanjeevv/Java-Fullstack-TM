import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class ArchitecturePage extends StatelessWidget {
  const ArchitecturePage({super.key});

  @override
  Widget build(BuildContext context) {
    // Initialize Firestore collection inside the build method
    final CollectionReference architectureCollection =
        FirebaseFirestore.instance.collection('architecture');

    return Scaffold(
      appBar: AppBar(title: Text('Architecture Wallpapers')),
      body: StreamBuilder(
        stream: architectureCollection.snapshots(),
        builder: (context, AsyncSnapshot<QuerySnapshot> snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }
          if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
            return Center(child: Text('No images added yet.'));
          }

          return GridView.builder(
            padding: EdgeInsets.all(8),
            gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2,
              crossAxisSpacing: 8,
              mainAxisSpacing: 8,
            ),
            itemCount: snapshot.data!.docs.length,
            itemBuilder: (context, index) {
              final DocumentSnapshot architectureImage =
                  snapshot.data!.docs[index];
              String imageUrl = architectureImage['url'];

              return Stack(
                children: [
                  ClipRRect(
                    borderRadius: BorderRadius.circular(10),
                    child: Image.network(imageUrl, fit: BoxFit.cover),
                  ),
                  Positioned(
                    top: 5,
                    right: 5,
                    child: IconButton(
                      icon: Icon(Icons.delete, color: Colors.red),
                      onPressed: () => _deleteImage(architectureImage.id),
                    ),
                  ),
                ],
              );
            },
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.pushNamed(context, '/add_image', arguments: 'architecture');
        },
        child: Icon(Icons.add),
      ),
    );
  }

  void _deleteImage(String docId) {
    FirebaseFirestore.instance.collection('architecture').doc(docId).delete();
  }
}
