variable "docker_config" {
  description = "Docker config to pull an image"
  type        = string
}

variable "server_ip" {
  description = "Server ip"
  type        = string
}

variable "host_name" {
  description = "Host name"
  type        = string
}

variable "vault_uri" {
  description = "Vault uri"
  type        = string
}

variable "image_tag" {
  description = "Image tag"
  type        = string
}
